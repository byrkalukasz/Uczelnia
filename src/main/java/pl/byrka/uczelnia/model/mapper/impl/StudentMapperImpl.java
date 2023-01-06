package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.MajorMapper;
import pl.byrka.uczelnia.model.mapper.StudentMapper;

import static pl.byrka.uczelnia.model.mapper.impl.PersonMapper.mapPersonFromDto;
import static pl.byrka.uczelnia.model.mapper.impl.PersonMapper.mapPersonToDto;

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
                .person(mapPersonToDto(studentEntity.getPerson()))
                .active(studentEntity.isActive())
                .build();
    }

    @Override
    public StudentEntity mapFromDTO(StudentDTO studentDTO) {
        return StudentEntity.builder()
                .id(studentDTO.getId())
                .person(mapPersonFromDto(studentDTO.getPerson()))
                .active(studentDTO.isActive())
                .build();

    }

    @Override
    public StudentEntity mapFromCreate(StudentCreateDTO studentCreateDTO) {
        return StudentEntity.builder()
                .active(true)
                .build();
    }
}
