package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.StudentGroup.StudentGroupDTO;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;
import pl.byrka.uczelnia.model.mapper.GroupMapper;
import pl.byrka.uczelnia.model.mapper.StudentGroupMapper;

@Service
public class StudentGroupMapperImpl implements StudentGroupMapper {
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;

    public StudentGroupMapperImpl(GroupMapper groupMapper, StudentMapper studentMapper) {
        this.groupMapper = groupMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentGroupEntity mapFromDTO(StudentGroupDTO src) {
        return StudentGroupEntity.builder()
                .id(src.getId())
                .student(studentMapper.mapFromDTO(src.getStudent()))
                .group(groupMapper.mapFromDTO(src.getGroup()))
                .build();
    }

    @Override
    public StudentGroupDTO mapFromEntity(StudentGroupEntity src) {
        return StudentGroupDTO.builder()
                .id(src.getId())
                .group(groupMapper.mapFromEntity(src.getGroup()))
                .student(studentMapper.mapFromEntity(src.getStudent()))
                .build();
    }
}
