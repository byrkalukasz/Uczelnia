package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerCreateEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

public interface LecturerMapper {
    LecturerEntity mapFromCreateEntity(LecturerCreateEntity src);
    LecturerDTO mapFromEntity(LecturerEntity src);
}
