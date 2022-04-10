package pl.byrka.uczelnia.service.Student.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.File.DocumentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
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

    public StudentApplicationImpl(StudentApplicationMapper studentApplicationMapper, StudentApplicationRepository studentApplicationRepository, MajorRepository majorRepository, SpecializationRepository specializationRepository, DocumentRepository documentRepository, StudentRepository studentRepository) {
        this.studentApplicationMapper = studentApplicationMapper;
        this.studentApplicationRepository = studentApplicationRepository;
        this.majorRepository = majorRepository;
        this.specializationRepository = specializationRepository;
        this.documentRepository = documentRepository;
        this.studentRepository = studentRepository;
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
        application.setStatus("CANCELED");
        var updatedApplication = studentApplicationRepository.save(application);
        return studentApplicationMapper.mapFromEntity(updatedApplication);
    }

    @Override
    public List<DocumentDTO> getAllDocumentsForApplicant(long id) {

        return null;
    }
    @Scheduled(cron = "0/30 * * * * *")
    public void test(){
        //Sprawdzenie czy istnieją jakies aplikacje
        var applicants = studentApplicationRepository.getAllActiveApplications("NEW");
        log.info("Downloading applicants list");
        //jeżeli istnieją sprawdz czy mają dokumenty
        for(var id : applicants){
            log.info("Checking application ID : " + id);
            var documentsForApplication = documentRepository.getAllDocumentsForApplication(id);
            if(documentsForApplication == null || documentsForApplication.isEmpty()){
                addCount(id);
            }else{
                var response = checkAllDocuments(documentsForApplication);
                if(response == true){

                }else{
                    addCount(id);
                }
            }
        }
    }
    private boolean checkAllDocuments(List<DocumentEntity> documentsList){
        log.info("Checking Documents");
        //Aktualnie wymagamy Wnoisek, życiorys i świadectwo
        List<String> documents = null;
        List<String> passType = Arrays.asList("MAT", "ZYC", "WPS");
        for(var obj : documentsList){
            var type = obj.getDocumentType();
            if(!documents.contains(type) && passType.contains(obj)){
                documents.add(obj.getDocumentType());
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
            cancelApplication(id);
            log.info("Canceled application with ID : " + id);
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
    }
}
