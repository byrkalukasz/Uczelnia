package pl.byrka.uczelnia.model.mapper;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;

@Service
public interface SpecializationMapper {
    SpecializationDTO mapFromEntity(SpecializationEntity src);
    SpecializationEntity mapFromDTO(SpecializationDTO src);
    SpecializationEntity mapFromCreate(SpecializationCreateDTO src);
}
