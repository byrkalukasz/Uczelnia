package pl.byrka.uczelnia.service.Student;

import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudetntCreateDTO;

import java.util.List;

public interface StudentService {
    StudentDTO getStudentById(long id);
    StudentDTO addStudent(StudetntCreateDTO studetntCreateDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllActiveStudents();

}
