package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.mapper.SpecializationMapper;

@Service
public class SpecializationMapperImpl implements SpecializationMapper {
    @Override
    public SpecializationDTO mapFromEntity(SpecializationEntity src) {
        return SpecializationDTO.builder()
                .id(src.getId())
                .name(src.getName())
                .active(src.isActive())
                .build();
    }

    @Override
    public SpecializationEntity mapFromDTO(SpecializationDTO src) {
        return SpecializationEntity.builder()
                .id(src.getId())
                .name(src.getName())
                .active(src.isActive())
                .build();
    }

    @Override
    public SpecializationEntity mapFromCreate(SpecializationCreateDTO src) {
        return SpecializationEntity.builder()
                .name(src.getName())
                .active(src.isActive())
                .build();
    }
}
