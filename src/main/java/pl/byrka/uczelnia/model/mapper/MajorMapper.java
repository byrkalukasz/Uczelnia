package pl.byrka.uczelnia.model.mapper;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;

@Service
public interface MajorMapper {
    MajorDTO mapFromEntity(MajorEntity src);
    MajorEntity mapFromDTO(MajorDTO src);
}
