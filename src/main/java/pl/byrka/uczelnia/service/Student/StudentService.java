package pl.byrka.uczelnia.service.Student;

import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentDTO getStudentById(long id);
    StudentDTO addStudent(StudentCreateDTO studentCreateDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllActiveStudents();
    List<Long> getAllStudentsWithoutGroups();

}
