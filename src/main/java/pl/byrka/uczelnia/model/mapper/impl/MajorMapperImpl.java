package pl.byrka.uczelnia.model.mapper.impl;


import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.mapper.MajorMapper;

@Service
public class MajorMapperImpl implements MajorMapper {
    @Override
    public MajorDTO mapFromEntity(MajorEntity src) {
        return MajorDTO.builder()
                .id(src.getId())
                .name(src.getName())
                .active(src.isActive())
                .build();
    }

    @Override
    public MajorEntity mapFromDTO(MajorDTO src) {
        return MajorEntity.builder()
                .id(src.getId())
                .name(src.getName())
                .active(src.isActive())
                .build();
    }
}
