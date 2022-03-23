package pl.byrka.uczelnia.service.Lecturer;

import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerCreateEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerUpdateEntity;

import java.util.List;

public interface LecturerService {
    List<LecturerDTO> getAllLecturer();
    LecturerDTO createLecturer(LecturerCreateEntity lecturerCreate);
    LecturerDTO getLecturerFromId(long id);
    LecturerDTO updateLecturer(LecturerUpdateEntity lecturerUpdate);
}
