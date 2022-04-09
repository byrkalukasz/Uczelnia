package pl.byrka.uczelnia.service.Specialization;

import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;

import java.util.List;

public interface SpecializationService {
    List<SpecializationDTO> getAllSpecializations();
    SpecializationDTO getSpecializationById(long id);
    SpecializationDTO addSpecialization(SpecializationCreateDTO specializationCreateDTO);
    SpecializationDTO updateSpecialization(SpecializationDTO specializationDTO);
}
