package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import static pl.byrka.uczelnia.model.mapper.impl.PersonMapper.mapPersonFromDto;
import static pl.byrka.uczelnia.model.mapper.impl.PersonMapper.mapPersonToDto;

@Service
public class StudentMapperImpl {

    public static StudentDTO mapStudentFromEntity(StudentEntity studentEntity) {
        return StudentDTO.builder()
                .id(studentEntity.getId())
                .person(mapPersonToDto(studentEntity.getPerson()))
                .creationDate(studentEntity.getCreationDate())
                .modificationEmployeeId(studentEntity.getModificationEmployeeId())
                .modificationDate(studentEntity.getModificationDate())
                .active(studentEntity.isActive())
                .build();
    }

    public static StudentEntity mapStudentFromDTO(StudentDTO studentDTO) {
        return StudentEntity.builder()
                .id(studentDTO.getId())
                .person(mapPersonFromDto(studentDTO.getPerson()))
                .active(studentDTO.isActive())
                .build();

    }

    public static StudentEntity mapStudentFromCreate(StudentCreateDTO studentCreateDTO) {
        return StudentEntity.builder()
                .person(mapPersonFromDto(studentCreateDTO.getPerson()))
                .active(true)
                .build();
    }
}
