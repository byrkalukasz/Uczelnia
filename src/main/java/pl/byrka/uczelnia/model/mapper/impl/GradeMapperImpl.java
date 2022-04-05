package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Grade.GradeCreateDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.Emuns.GradeStateEnum;
import pl.byrka.uczelnia.model.Emuns.GradeValueEnum;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.model.mapper.GradeMapper;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.model.mapper.StudentMapper;
import pl.byrka.uczelnia.model.mapper.SubjectMapper;

@Service
public class GradeMapperImpl implements GradeMapper {
    private final LecturerMapper lecturerMapper;
    private final SubjectMapper subjectMapper;
    private final StudentMapper studentMapper;

    public GradeMapperImpl(LecturerMapper lecturerMapper, SubjectMapper subjectMapper, StudentMapper studentMapper) {
        this.lecturerMapper = lecturerMapper;
        this.subjectMapper = subjectMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public GradeDTO mapFromEntity(GradeEntity gradeEntity) {
        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setId(gradeEntity.getId());
        gradeDTO.setGrade(GradeValueEnum.valueOf(gradeEntity.getGrade()));
        gradeDTO.setStatus(GradeStateEnum.valueOf(gradeEntity.getStatus()));
        gradeDTO.setLecturer(lecturerMapper.mapFromEntity(gradeEntity.getLecturer()));
        gradeDTO.setSubject(subjectMapper.mapSubjectToDTO(gradeEntity.getSubject()));
        gradeDTO.setStudent(studentMapper.mapFromEntity(gradeEntity.getStudent()));

        return gradeDTO;
    }

    @Override
    public GradeEntity mapFromDTO(GradeDTO gradeDTO) {
        GradeEntity gradeEntity = new GradeEntity();
        gradeEntity.setId(gradeDTO.getId());
        gradeEntity.setGrade(gradeDTO.getGrade().getGradeValueEnum());
        gradeEntity.setStatus(gradeDTO.getStatus().getGradeStateEnum());
        gradeEntity.setStudent(studentMapper.mapFromDTO(gradeDTO.getStudent()));
        gradeEntity.setLecturer(lecturerMapper.mapFromDTO(gradeDTO.getLecturer()));
        gradeEntity.setSubject(subjectMapper.mapToEntity(gradeDTO.getSubject()));
        return gradeEntity;
    }

    @Override
    public GradeEntity mapFromCreate(GradeCreateDTO gradeCreateDTO) {
        return null;
    }

    @Override
    public GradeEntity mapCreatetoEntity(GradeCreateDTO gradeCreateDTO, LecturerEntity lecturer, SubjectEntity subject, StudentEntity student) {
        GradeEntity gradeEntity = new GradeEntity();
        gradeEntity.setGrade(gradeCreateDTO.getGrade().toString());
        gradeEntity.setStatus(gradeCreateDTO.getStatus().toString());
        gradeEntity.setStudent(student);
        gradeEntity.setLecturer(lecturer);
        gradeEntity.setSubject(subject);
        return gradeEntity;
    }
}
