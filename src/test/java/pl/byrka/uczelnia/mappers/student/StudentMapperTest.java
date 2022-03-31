package pl.byrka.uczelnia.mappers.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.StudentMapper;
import pl.byrka.uczelnia.model.mapper.impl.StudentMapperImpl;


public class StudentMapperTest {
    StudentMapperImpl studentMapper = new StudentMapperImpl();
    public static StudentEntity student;
    public static StudentDTO studentDTO;
    public static StudentCreateDTO studentCreateDTO;
    @BeforeAll
    static void setup(){
        student = new StudentEntity();
        student.setId(1);
        student.setName("Janusz");
        student.setSurname("Pracz");

        studentDTO = new StudentDTO();
        studentDTO.setId(1);
        studentDTO.setName("Janusz");
        studentDTO.setSurname("Pracz");

        studentCreateDTO = new StudentCreateDTO();
        studentCreateDTO.setName("Janusz");
        studentCreateDTO.setSurname("Pracz");
    }
    @Test
    void mapFromEntity(){
        var actual = studentMapper.mapFromEntity(student);

        Assertions.assertEquals(studentDTO.getSurname(), actual.getSurname());
        Assertions.assertEquals(studentDTO.getName(), actual.getName());
    }
    @Test
    void mapFromCreate(){
        var actual = studentMapper.mapFromCreate(studentCreateDTO);
        Assertions.assertEquals(studentCreateDTO.getSurname(), actual.getSurname());
        Assertions.assertEquals(studentCreateDTO.getName(), actual.getName());
    }
    @Test
    void mapFromDTO(){
        var actual = studentMapper.mapFromDTO(studentDTO);
        Assertions.assertEquals(student.getId(), actual.getId());
        Assertions.assertEquals(student.getName(), actual.getName());
    }
}
