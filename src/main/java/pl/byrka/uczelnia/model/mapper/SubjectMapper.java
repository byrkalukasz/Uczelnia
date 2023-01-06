package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

public interface SubjectMapper {
     SubjectDTO mapSubjectToDTO(SubjectEntity src);
     SubjectEntity mapSubjectToEntity(SubjectDTO src, LecturerEntity lecturer);
     SubjectEntity mapToEntity(SubjectDTO subjectDTO);
}
