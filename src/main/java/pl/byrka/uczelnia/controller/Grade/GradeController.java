package pl.byrka.uczelnia.controller.Grade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Grade.GradeCreateDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeUpdateDTO;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.service.Grade.GradeService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<GradeDTO>> getAllGrades()
    {
        var result = gradeService.getAllGrades();
        return ResponseEntity.ok(result);
    }
    @GetMapping("{student_id}")
    public ResponseEntity<List<GradeDTO>> getAllGradesForStudent(@PathVariable("student_id") long student_id){
        var result = gradeService.getAllGradesForStudent(student_id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "/add/grade")
    public ResponseEntity<GradeDTO> addNewGrade(@RequestBody GradeCreateDTO gradeDTO){
        var result = gradeService.createGrade(gradeDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PostMapping(value = "/add/grades")
    public ResponseEntity<List<GradeDTO>> addListGrades(@RequestBody List<GradeCreateDTO> gradeDTOList){
        var result = gradeService.createListGrades(gradeDTOList);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping(value = "/update/grade")
    public ResponseEntity<GradeDTO> updateGrade(@RequestBody GradeUpdateDTO gradeDTO){
        var result = gradeService.updateGrade(gradeDTO);
        return ResponseEntity.ok(result);
    }
    @PutMapping(value = "/update/grades")
    public ResponseEntity<List<GradeDTO>> updateListGrade(@RequestBody List<GradeUpdateDTO> gradeDTOList){
        var ressult = gradeService.updateListGrades(gradeDTOList);
        return new ResponseEntity<>(ressult, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public void deleteGrade(@PathVariable long id){
        gradeService.deleteGrade(id);
    }
}
