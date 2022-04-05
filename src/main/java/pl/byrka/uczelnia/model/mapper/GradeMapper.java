package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Grade.GradeCreateDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

public interface GradeMapper {
    public GradeDTO mapFromEntity(GradeEntity gradeEntity);
    GradeEntity mapFromDTO(GradeDTO gradeDTO);
    GradeEntity mapFromCreate(GradeCreateDTO gradeCreateDTO);
    GradeEntity mapCreatetoEntity(GradeCreateDTO gradeCreateDTO, LecturerEntity lecturer, SubjectEntity subject, StudentEntity student);
}
