package pl.byrka.uczelnia.service.Student.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.File.DocumentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.model.mapper.StudentApplicationMapper;
import pl.byrka.uczelnia.repository.Major.MajorRepository;
import pl.byrka.uczelnia.repository.Specialization.SpecializationRepository;
import pl.byrka.uczelnia.repository.Student.StudentApplicationRepository;
import pl.byrka.uczelnia.service.Student.StudentApplicationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentApplicationImpl implements StudentApplicationService {
    private final StudentApplicationMapper studentApplicationMapper;
    private final StudentApplicationRepository studentApplicationRepository;
    private final MajorRepository majorRepository;
    private final SpecializationRepository specializationRepository;

    public StudentApplicationImpl(StudentApplicationMapper studentApplicationMapper, StudentApplicationRepository studentApplicationRepository, MajorRepository majorRepository, SpecializationRepository specializationRepository) {
        this.studentApplicationMapper = studentApplicationMapper;
        this.studentApplicationRepository = studentApplicationRepository;
        this.majorRepository = majorRepository;
        this.specializationRepository = specializationRepository;
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
}
