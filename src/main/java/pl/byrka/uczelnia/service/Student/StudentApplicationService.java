package pl.byrka.uczelnia.service.Student;

import pl.byrka.uczelnia.model.DTO.File.DocumentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;

import java.util.List;

public interface StudentApplicationService {
    List<StudentApplicationDTO> getAllApplications();
    StudentApplicationDTO getApplicationByID(long id);
    StudentApplicationDTO addNewApplication(StudentApplicationCreateDTO studentApplicationCreateDTO);
    StudentApplicationDTO cancelApplication(long id);
    List<DocumentDTO> getAllDocumentsForApplicant(long id);
    void checkStudentApplications();
    void chanceApplicationStatus(long id);
}
