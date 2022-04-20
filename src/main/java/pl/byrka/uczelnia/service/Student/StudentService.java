package pl.byrka.uczelnia.service.Student;

import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<StudentDTO> getStudentById(long id);
    StudentDTO addStudent(StudentCreateDTO studentCreateDTO);
    List<StudentDTO> getAllStudents();
    Optional<StudentDTO>  updateStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllActiveStudents();

}
