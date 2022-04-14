package pl.byrka.uczelnia.service.Subject;

import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectCreate;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> getAllSubjectWithLecturer();
    SubjectDTO createNewSubject(SubjectCreate subjectEntity);
    SubjectDTO getSubjectById(long id);
    List<SubjectDTO> getAllSubjectByLecturer(long id);
}
