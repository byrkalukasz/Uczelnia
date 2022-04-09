package pl.byrka.uczelnia.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.byrka.uczelnia.model.DTO.StudentGroup.StudentGroupDTO;
import pl.byrka.uczelnia.service.StudentGruop.StudentGroupService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/studentgroup")
public class StudentGroupController {
    private final StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping
    public ResponseEntity<List<StudentGroupDTO>> getAllStudentGroup()
    {
        log.info("Entering [getAllStudentGroup]");
        var result = studentGroupService.getAllStudentGroup();
        return ResponseEntity.ok(result);
    }
    @GetMapping("{student_id}")
    public ResponseEntity<List<StudentGroupDTO>> getAllStudentroupForStudent(@PathVariable("student_id") long student_id){
        log.info("Entering [getAllStudentroupForStudent] with id" + student_id);
        var result = studentGroupService.getAllGroupsForStudent(student_id);
        return ResponseEntity.ok(result);
    }
}
