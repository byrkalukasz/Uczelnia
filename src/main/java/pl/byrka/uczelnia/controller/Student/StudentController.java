package pl.byrka.uczelnia.controller.Student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.service.Student.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") long id){
        log.info("Entering [getStudentById] with ID = {}", id);
        var result = studentService.getStudentById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        log.info("Entering [getAllStudents]");
        var result = studentService.getAllStudents();
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentCreateDTO studentCreateDTO){
        log.info("Entering [creatingStudent]");
        var result = studentService.addStudent(studentCreateDTO);
        log.info("Created student with ID = {}", result.getId());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
