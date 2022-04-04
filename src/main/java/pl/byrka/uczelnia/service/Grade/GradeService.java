package pl.byrka.uczelnia.service.Grade;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Grade.GradeCreateDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeUpdateDTO;

import java.util.List;

@Service
public interface GradeService {
    public List<GradeDTO> getAllGrades();
    List<GradeDTO> getAllGradesForStudent(long student_id);
    GradeDTO createGrade(GradeCreateDTO gradeCreateDTO);
    List<GradeDTO> createListGrades(List<GradeCreateDTO> gradeCreateDTOS);
    GradeDTO updateGrade(GradeUpdateDTO gradeDTO);
    List<GradeDTO> updateListGrades(List<GradeUpdateDTO> GradeDTO);
    void deleteGrade(long id);
}
