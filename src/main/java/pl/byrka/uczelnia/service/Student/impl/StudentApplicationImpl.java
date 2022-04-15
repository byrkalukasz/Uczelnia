package pl.byrka.uczelnia.service.Student.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.File.DocumentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationMessage;
import pl.byrka.uczelnia.model.Emuns.ApplicationStatusEnum;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.StudentApplicationMapper;
import pl.byrka.uczelnia.repository.File.DocumentRepository;
import pl.byrka.uczelnia.repository.Major.MajorRepository;
import pl.byrka.uczelnia.repository.Specialization.SpecializationRepository;
import pl.byrka.uczelnia.repository.Student.StudentApplicationRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.Student.StudentApplicationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class StudentApplicationImpl implements StudentApplicationService {
    private final StudentApplicationMapper studentApplicationMapper;
    private final StudentApplicationRepository studentApplicationRepository;
    private final MajorRepository majorRepository;
    private final SpecializationRepository specializationRepository;
    private final DocumentRepository documentRepository;
    private final StudentRepository studentRepository;
    private final JmsTemplate jmsTemplate;
    private final Gson gson;
    private String destination = "${activemq.send}";

    public StudentApplicationImpl(StudentApplicationMapper studentApplicationMapper, StudentApplicationRepository studentApplicationRepository, MajorRepository majorRepository, SpecializationRepository specializationRepository, DocumentRepository documentRepository, StudentRepository studentRepository, JmsTemplate jmsTemplate, Gson gson) {
        this.studentApplicationMapper = studentApplicationMapper;
        this.studentApplicationRepository = studentApplicationRepository;
        this.majorRepository = majorRepository;
        this.specializationRepository = specializationRepository;
        this.documentRepository = documentRepository;
        this.studentRepository = studentRepository;
        this.jmsTemplate = jmsTemplate;
        this.gson = gson;
    }

    @Override
    public List<StudentApplicationDTO> getAllApplications() {
        var response = studentApplicationRepository.findAll();
        List<StudentApplicationDTO> dst = new ArrayList<>();
        for(var obj : response){
            dst.add(studentApplicationMapper.mapFromEntity(obj));
        }
        return dst;
    }

    @Override
    public StudentApplicationDTO getApplicationByID(long id) {
        var response = studentApplicationRepository.getById(id);
        var dst = studentApplicationMapper.mapFromEntity(response);
        return dst;
    }

    @Override
    public StudentApplicationDTO addNewApplication(StudentApplicationCreateDTO studentApplicationCreateDTO) {
        var major = majorRepository.getById(studentApplicationCreateDTO.getMajor());
        var specialization = specializationRepository.getById(studentApplicationCreateDTO.getSpecialization());
        var request = studentApplicationMapper.mapFromCreate(studentApplicationCreateDTO, major, specialization);
        var result = studentApplicationRepository.save(request);
        return studentApplicationMapper.mapFromEntity(result);
    }

    @Override
    public StudentApplicationDTO cancelApplication(long id) {
        var application = studentApplicationRepository.getById(id);
        application.setStatus(ApplicationStatusEnum.CANCELED.toString());
        application.setMessage("Anulowano ręcznie");
        var updatedApplication = studentApplicationRepository.save(application);
        return studentApplicationMapper.mapFromEntity(updatedApplication);
    }

    @Override
    public List<DocumentDTO> getAllDocumentsForApplicant(long id) {

        return null;
    }
    @Scheduled(cron = "${activemq.cron.expression}")
    public void sendApplicationToValidator(){
        log.info("Downloading applicants list");
        var applicants = studentApplicationRepository.findAll();
        for(var obj : applicants){
            StudentApplicationMessage send = studentApplicationMapper.mapToMessage(obj);
            var string = gson.toJson(send);
            jmsTemplate.convertAndSend(destination,string);
        }

    }
    @JmsListener(destination = "${activemq.receive}")
    public void reviceStudentApplications(StudentApplicationEntity studentApplication){
        log.info("Reciving studentApplication");
    }
    @Scheduled(cron = "${cron.expression}")
    public void checkStudentApplications(){
        log.info("Downloading applicants list");
        //Sprawdzenie czy istnieją jakies aplikacje
        var applicants = studentApplicationRepository.getAllActiveApplications("NEW");
        //jeżeli istnieją sprawdz czy mają dokumenty
        for(var id : applicants){
            log.info("Checking application ID : " + id);
            var documentsForApplication = documentRepository.getAllDocumentsForApplication(id);
            if(documentsForApplication == null || documentsForApplication.isEmpty()){
                addCount(id);
            }else{
                var response = checkAllDocuments(documentsForApplication);
                if(response == true){
                    createStudent(id);
                }else{
                    addCount(id);
                }
            }
        }
    }

    @Override
    public void chanceApplicationStatus(long id) {
        var application = studentApplicationRepository.getById(id);
        application.setStatus(ApplicationStatusEnum.NEW.toString());
        application.setCount("0");
        application.setMessage(null);
        studentApplicationRepository.save(application);
    }

    private boolean checkAllDocuments(List<DocumentEntity> documentsList){
        log.info("Checking Documents");
        //Aktualnie wymagamy Wnoisek, życiorys i świadectwo
        List<String> documents = new ArrayList<>();
        List<String> passType = Arrays.asList("MAT", "ZYC", "WPS");
        for(var obj : documentsList){
            var type = obj.getType();
            if(!documents.contains(type) && passType.contains(type)){
                documents.add(obj.getType());
            }
        }
        if(documents.size() == 3){
            return true;
        }else{
            return false;
        }
    }
    private void addCount(long id){
        var application = studentApplicationRepository.getById(id);
        Long count = Long.parseLong(application.getCount());
        if(count == 4) {
            log.info("Canceled application with ID : " + id);
            application.setMessage("Aplikacja anulowana automatycznie, brak wymaganych dokumentów");
            application.setStatus(ApplicationStatusEnum.CANCELED.toString());
            //Czemu to nie działa???
            //cancelApplicationByScheduler(id, "Aplikacja anulowana automatycznie, brak wymaganych dokumentów");
        }else{
            count++;
            application.setCount(count.toString());
        }
        var updatedApplication = studentApplicationRepository.save(application);
    }
    private void createStudent(long id){
        var applicant = studentApplicationRepository.getById(id);
        var student = StudentEntity.builder()
                .name(applicant.getName())
                .surname(applicant.getSurname())
                .active(true)
                .major(applicant.getMajor())
                .specialization(applicant.getSpecialization())
                .build();
        studentRepository.save(student);
        applicant.setMessage("Pomyślnie utworzono studenta");
        applicant.setStatus(ApplicationStatusEnum.DONE.toString());
        studentApplicationRepository.save(applicant);
    }
    //Czemu w tej metodzie nie aktualizuje się status hmm....
    private void cancelApplicationByScheduler(long id, String message){
        log.info("Enter calcel with ID : " + id);
        var applicationEntity = studentApplicationRepository.getById(id);
        log.info("Find application with ID : " + applicationEntity.getId());
        applicationEntity.setStatus(ApplicationStatusEnum.CANCELED.toString());
        applicationEntity.setMessage(message);
        log.info("Change application with ID : " + applicationEntity.getId() + applicationEntity.getName());
        var test = studentApplicationRepository.save(applicationEntity);
    }
}
