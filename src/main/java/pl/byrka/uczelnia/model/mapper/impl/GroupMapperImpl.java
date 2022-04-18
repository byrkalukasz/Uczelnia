package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.mapper.GroupMapper;
import pl.byrka.uczelnia.model.mapper.MajorMapper;
import pl.byrka.uczelnia.model.mapper.SpecializationMapper;
import pl.byrka.uczelnia.model.mapper.SubjectMapper;

@Service
public class GroupMapperImpl implements GroupMapper {
    private final MajorMapper majorMapper;
    private final SpecializationMapper specializationMapper;
    private final SubjectMapper subjectMapper;

    public GroupMapperImpl(MajorMapper majorMapper, SpecializationMapper specializationMapper, SubjectMapper subjectMapper) {
        this.majorMapper = majorMapper;
        this.specializationMapper = specializationMapper;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public GroupDTO mapFromEntity(GroupEntity src) {

        return GroupDTO.builder()
                .id(src.getId())
                .fullName(src.getFullName())
                .learningSchedule(LearningscheduleEnum.valueOf(src.getLearningSchedule()))
                .learningType(LearningTypeEnum.valueOf(src.getLearningType()))
                .major(majorMapper.mapFromEntity(src.getMajor()))
                .maxStudentCount(src.getMaxStudentCount())
                .shortName(src.getShortName())
                .specialization(specializationMapper.mapFromEntity(src.specialization))
                .StartYear(src.getStartYear())
                .subject(subjectMapper.mapSubjectToDTO(src.subject))
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
                .major(majorMapper.mapFromDTO(src.major))
                .maxStudentCount(src.getMaxStudentCount())
                .shortName(src.getShortName())
                .specialization(specializationMapper.mapFromDTO(src.specialization))
                .StartYear(src.getStartYear())
                .subject(subjectMapper.mapToEntity(src.subject))
                .type(src.getType().getGrooupTypeEnum())
                .build();
    }
}
