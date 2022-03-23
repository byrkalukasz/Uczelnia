package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

public interface SubjectMapper {
     SubjectDTO mapSubjectToDTO(SubjectEntity src);
}
