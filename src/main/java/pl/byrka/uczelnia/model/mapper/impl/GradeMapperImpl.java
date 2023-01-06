package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Component;
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

@Component
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
        return GradeDTO.builder()
                .id(gradeEntity.getId())
                .grade(GradeValueEnum.valueOf(gradeEntity.getGrade()))
                .status(GradeStateEnum.valueOf(gradeEntity.getStatus()))
                .lecturer(lecturerMapper.mapFromEntity(gradeEntity.getLecturer()))
                .subject(subjectMapper.mapSubjectToDTO(gradeEntity.getSubject()))
                .student(studentMapper.mapFromEntity(gradeEntity.getStudent()))
                .build();
    }

    @Override
    public GradeEntity mapFromDTO(GradeDTO gradeDTO) {
        return GradeEntity.builder()
                .id(gradeDTO.getId())
                .grade(gradeDTO.getGrade().getGradeValueEnum())
                .status(gradeDTO.getStatus().getGradeStateEnum())
                .lecturer(lecturerMapper.mapFromDTO(gradeDTO.getLecturer()))
                .subject(subjectMapper.mapToEntity(gradeDTO.getSubject()))
                .student(studentMapper.mapFromDTO(gradeDTO.getStudent()))
                .build();
    }

    @Override
    public GradeEntity mapFromCreate(GradeCreateDTO gradeCreateDTO) {
        return null;
    }

    @Override
    public GradeEntity mapCreatetoEntity(GradeCreateDTO gradeCreateDTO, LecturerEntity lecturer, SubjectEntity subject, StudentEntity student) {
        return GradeEntity.builder()
                .grade(gradeCreateDTO.getGrade().getGradeValueEnum())
                .status(gradeCreateDTO.getStatus().getGradeStateEnum())
                .lecturer(lecturer)
                .subject(subject)
                .student(student)
                .build();
    }
}
