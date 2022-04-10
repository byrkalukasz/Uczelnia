package pl.byrka.uczelnia.model.mapper.impl;


import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
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
                .type(LearningTypeEnum.valueOf(src.getType()))
                .schedule(LearningscheduleEnum.valueOf(src.getSchedule()))
                .startYear(src.getStartYear())
                .build();
    }

    @Override
    public MajorEntity mapFromDTO(MajorDTO src) {
        return MajorEntity.builder()
                .id(src.getId())
                .name(src.getName())
                .active(src.isActive())
                .type(src.getType().getLearningTypeEnum())
                .schedule(src.getSchedule().getGradeValueEnum())
                .startYear(src.getStartYear())
                .build();
    }
}
