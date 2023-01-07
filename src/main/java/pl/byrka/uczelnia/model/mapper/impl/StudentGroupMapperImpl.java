package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.StudentGroup.StudentGroupDTO;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;
import pl.byrka.uczelnia.model.mapper.GroupMapper;
import pl.byrka.uczelnia.model.mapper.StudentGroupMapper;

import static pl.byrka.uczelnia.model.mapper.impl.StudentMapperImpl.mapStudentFromDTO;
import static pl.byrka.uczelnia.model.mapper.impl.StudentMapperImpl.mapStudentFromEntity;

@Service
public class StudentGroupMapperImpl implements StudentGroupMapper {
    private final GroupMapper groupMapper;

    public StudentGroupMapperImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public StudentGroupEntity mapFromDTO(StudentGroupDTO src) {
        return StudentGroupEntity.builder()
                .id(src.getId())
                .student(mapStudentFromDTO(src.getStudent()))
                .group(groupMapper.mapFromDTO(src.getGroup()))
                .build();
    }

    @Override
    public StudentGroupDTO mapFromEntity(StudentGroupEntity src) {
        return StudentGroupDTO.builder()
                .id(src.getId())
                .group(groupMapper.mapFromEntity(src.getGroup()))
                .student(mapStudentFromEntity(src.getStudent()))
                .build();
    }
}
