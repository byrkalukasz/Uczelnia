package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.MajorMapper;
import pl.byrka.uczelnia.model.mapper.StudentMapper;

@Service
public class StudentMapperImpl implements StudentMapper {
    private MajorMapper majorMapper;

    public StudentMapperImpl(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    @Override
    public StudentDTO mapFromEntity(StudentEntity studentEntity) {
        StudentDTO result = new StudentDTO();
        result.setId(studentEntity.getId());
        result.setName(studentEntity.getName());
        result.setSurname(studentEntity.getSurname());
        result.setActive(studentEntity.isActive());
        result.setMajor(majorMapper.mapFromEntity(studentEntity.getMajor()));

        return result;
    }

    @Override
    public StudentEntity mapFromDTO(StudentDTO studentDTO) {
        StudentEntity result = new StudentEntity();
        result.setId(studentDTO.getId());
        result.setName(studentDTO.getName());
        result.setSurname(studentDTO.getSurname());
        result.setActive(studentDTO.isActive());
        result.setMajor(majorMapper.mapFromDTO(studentDTO.getMajor()));
        return result;
    }

    @Override
    public StudentEntity mapFromCreate(StudentCreateDTO studentCreateDTO) {
        StudentEntity student = new StudentEntity();
        student.setName(studentCreateDTO.getName());
        student.setSurname(studentCreateDTO.getSurname());
        student.setActive(true);
        return student;
    }
}
