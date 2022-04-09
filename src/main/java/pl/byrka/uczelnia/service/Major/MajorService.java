package pl.byrka.uczelnia.service.Major;

import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;

import java.util.List;

public interface MajorService {
    List<MajorDTO> getAllMajor();
    MajorDTO getMajorById(long id);
}
