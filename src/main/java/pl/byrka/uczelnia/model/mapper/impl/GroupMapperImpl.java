package pl.byrka.uczelnia.model.mapper.impl;

import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.mapper.GroupMapper;

public class GroupMapperImpl implements GroupMapper {
    @Override
    public GroupDTO mapFromEntity(GroupEntity src) {

        return GroupDTO.builder()
                .id(src.getId())
                .fullName(src.getFullName())
                .learningSchedule(LearningscheduleEnum.valueOf(src.getLearningSchedule()))
                .learningType(LearningTypeEnum.valueOf(src.getLearningType()))
                .major(src.getMajor())
                .maxStudentCount(src.getMaxStudentCount())
                .shortName(src.getShortName())
                .specialization(src.getSpecialization())
                .StartYear(src.getStartYear())
                .subject(src.getSubject())
                .type(GroupTypeEnum.valueOf(src.getType()))
                .build();
    }

    @Override
    public GroupEntity mapFromDTO(GroupDTO src) {

        return GroupEntity.builder()
                .id(src.getId())
                .fullName(src.getFullName())
                .learningSchedule(src.getLearningSchedule().getGradeValueEnum())
                .learningType(src.getLearningType().getGradeValueEnum())
                .major(src.getMajor())
                .maxStudentCount(src.getMaxStudentCount())
                .shortName(src.getShortName())
                .specialization(src.getSpecialization())
                .StartYear(src.getStartYear())
                .subject(src.getSubject())
                .type(src.getType().getGrojupTypeEnum())
                .build();
    }
}
