package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudetntCreateDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

public interface StudentMapper {
    StudentDTO mapFromEntity(StudentEntity studentEntity);
    StudentEntity mapFromDTO(StudentDTO studentDTO);
    StudentEntity mapFromCreate(StudetntCreateDTO studetntCreateDTO);
}
