package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationMessage;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;

public interface StudentApplicationMapper {
    StudentApplicationDTO mapFromEntity(StudentApplicationEntity src);
    StudentApplicationEntity mapFromDTO(StudentApplicationDTO src);
    StudentApplicationEntity mapFromCreate(StudentApplicationCreateDTO src, MajorEntity major, SpecializationEntity specialization);
    StudentApplicationMessage mapToMessage(StudentApplicationEntity studentApplication);
}
