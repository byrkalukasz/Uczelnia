package pl.byrka.uczelnia.controller.Grade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Grade.GradeCreateDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeUpdateDTO;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.service.Grade.GradeService;

import java.util.List;

@Slf4j
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
        log.info("Entering [getAllGrades]");
        var result = gradeService.getAllGrades();
        return ResponseEntity.ok(result);
    }
    @GetMapping("{student_id}")
    public ResponseEntity<List<GradeDTO>> getAllGradesForStudent(@PathVariable("student_id") long student_id){
        log.info("Entering [getAllGradesForStudent] with id" + student_id);
        var result = gradeService.getAllGradesForStudent(student_id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "/add/grade")
    public ResponseEntity<GradeDTO> addNewGrade(@RequestBody GradeCreateDTO gradeDTO){
        log.info("Entering [addNewGrade]");
        var result = gradeService.createGrade(gradeDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PostMapping(value = "/add/grades")
    public ResponseEntity<List<GradeDTO>> addListGrades(@RequestBody List<GradeCreateDTO> gradeDTOList){
        log.info("Entering [addListGrades]");
        var result = gradeService.createListGrades(gradeDTOList);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping(value = "/update/grade")
    public ResponseEntity<GradeDTO> updateGrade(@RequestBody GradeUpdateDTO gradeDTO){
        log.info("Entering [updateGrade]");
        var result = gradeService.updateGrade(gradeDTO);
        return ResponseEntity.ok(result);
    }
    @PutMapping(value = "/update/grades")
    public ResponseEntity<List<GradeDTO>> updateListGrade(@RequestBody List<GradeUpdateDTO> gradeDTOList){
        log.info("Entering [updateListGrade]");
        log.info("Grades to upgrade: " + gradeDTOList.size());
        var ressult = gradeService.updateListGrades(gradeDTOList);
        return new ResponseEntity<>(ressult, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public void deleteGrade(@PathVariable long id){
        log.info("Entering [getAllgroups]");
        gradeService.deleteGrade(id);
    }
}
