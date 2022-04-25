package pl.byrka.uczelnia.service.Specialization;

import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;

import java.util.List;
import java.util.Optional;

public interface SpecializationService {
    List<SpecializationDTO> getAllSpecializations();
    Optional<SpecializationDTO> getSpecializationById(long id);
    Optional<SpecializationDTO> addSpecialization(SpecializationCreateDTO specializationCreateDTO);
    Optional<SpecializationDTO> updateSpecialization(SpecializationDTO specializationDTO);
}
