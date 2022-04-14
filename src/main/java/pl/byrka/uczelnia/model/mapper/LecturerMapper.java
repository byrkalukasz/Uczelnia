package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerCreateDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

public interface LecturerMapper {
    LecturerEntity mapFromCreateEntity(LecturerCreateDTO src);
    LecturerDTO mapFromEntity(LecturerEntity src);
    LecturerEntity mapFromDTO(LecturerDTO lecturerDTO);
}
