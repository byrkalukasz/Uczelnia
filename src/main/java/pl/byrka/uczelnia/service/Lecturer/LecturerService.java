package pl.byrka.uczelnia.service.Lecturer;

import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerCreateDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface LecturerService {
    List<LecturerDTO> getAllLecturer();
    Optional<LecturerDTO> createLecturer(LecturerCreateDTO lecturerCreate);
    Optional<LecturerDTO> getLecturerFromId(long id);
    Optional<LecturerDTO> updateLecturer(LecturerUpdateDTO lecturerUpdate);
}
