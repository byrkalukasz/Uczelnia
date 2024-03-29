package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.model.mapper.SubjectMapper;

@Service
public class SubjectMapperImpl implements SubjectMapper {
    private final LecturerMapper lecturerMapper;

    public SubjectMapperImpl(LecturerMapper lecturerMapper) {
        this.lecturerMapper = lecturerMapper;
    }
    @Override
    public SubjectDTO mapSubjectToDTO(SubjectEntity src)
    {
        return SubjectDTO.builder()
                .ects(src.getEcts())
                .name(src.getName())
                .ects(src.getEcts())
                .type(GroupTypeEnum.valueOf(src.getType()))
                .lecturer(lecturerMapper.mapFromEntity(src.getLecturer()))
                .build();
    }


    @Override
    public SubjectEntity mapSubjectToEntity(SubjectDTO src,LecturerEntity lecturer ) {
        return SubjectEntity.builder()
                .ects(src.getEcts())
                .name(src.getName())
                .ects(src.getEcts())
                .type(src.getType().getGrooupTypeEnum())
                .lecturer(lecturer)
                .build();
    }

    @Override
    public SubjectEntity mapToEntity(SubjectDTO subjectDTO) {
        return SubjectEntity.builder()
                .ects(subjectDTO.getEcts())
                .name(subjectDTO.getName())
                .ects(subjectDTO.getEcts())
                .type(String.valueOf(subjectDTO.getType()))
                .lecturer(lecturerMapper.mapFromDTO(subjectDTO.getLecturer()))
                .build();
    }

}
