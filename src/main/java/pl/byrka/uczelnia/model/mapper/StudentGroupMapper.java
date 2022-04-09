package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.StudentGroup.StudentGroupDTO;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;

public interface StudentGroupMapper {
    StudentGroupEntity mapFromDTO(StudentGroupDTO src);
    StudentGroupDTO mapFromEntity(StudentGroupEntity src);
}
