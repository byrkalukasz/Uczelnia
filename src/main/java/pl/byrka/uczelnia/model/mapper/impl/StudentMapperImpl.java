package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.MajorMapper;
import pl.byrka.uczelnia.model.mapper.StudentMapper;

@Service
public class StudentMapperImpl implements StudentMapper {
    private final MajorMapper majorMapper;

    public StudentMapperImpl(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    @Override
    public StudentDTO mapFromEntity(StudentEntity studentEntity) {
        return StudentDTO.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .active(studentEntity.isActive())
                .build();
    }

    @Override
    public StudentEntity mapFromDTO(StudentDTO studentDTO) {
        return StudentEntity.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .active(studentDTO.isActive())
                .build();

    }

    @Override
    public StudentEntity mapFromCreate(StudentCreateDTO studentCreateDTO) {
        return StudentEntity.builder()
                .name(studentCreateDTO.getName())
                .surname(studentCreateDTO.getSurname())
                .active(true)
                .build();
    }
}
