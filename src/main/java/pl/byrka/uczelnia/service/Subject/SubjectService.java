package pl.byrka.uczelnia.service.Subject;

import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;


import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<SubjectDTO> getAllSubjectWithLecturer();
    Optional<SubjectDTO> createNewSubject(SubjectDTO subjectEntity);
    Optional<SubjectDTO> getSubjectById(long id);
    List<SubjectDTO> getAllSubjectByLecturer(long id);
}
