package pl.byrka.uczelnia.service.Subject;

import pl.byrka.uczelnia.model.DTO.Subject.SubjectCreateDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> getAllSubjectWithLecturer();
    SubjectDTO createNewSubject(SubjectCreate subjectEntity);
    SubjectDTO getSubjectById(long id);
}
