package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudetntCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.StudentMapper;

@Service
public class StudentMapperImpl implements StudentMapper {
    @Override
    public StudentDTO mapFromEntity(StudentEntity studentEntity) {
        StudentDTO result = new StudentDTO();
        result.setId(studentEntity.getId());
        result.setName(studentEntity.getName());
        result.setSurname(studentEntity.getSurname());

        return result;
    }

    @Override
    public StudentEntity mapFromDTO(StudentDTO studentDTO) {
        StudentEntity result = new StudentEntity();
        result.setId(studentDTO.getId());
        result.setName(studentDTO.getName());
        result.setSurname(studentDTO.getSurname());

        return result;
    }

    @Override
    public StudentEntity mapFromCreate(StudetntCreateDTO studetntCreateDTO) {
        StudentEntity student = new StudentEntity();
        student.setName(studetntCreateDTO.getName());
        student.setSurname(studetntCreateDTO.getSurname());
        return student;
    }
}
