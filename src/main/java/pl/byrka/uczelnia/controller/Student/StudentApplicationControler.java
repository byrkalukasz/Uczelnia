package pl.byrka.uczelnia.controller.Student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.File.ResponseMessage;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.service.Student.StudentApplicationService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/application")
public class StudentApplicationControler {
    private final StudentApplicationService studentApplicationService;

    public StudentApplicationControler(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentApplicationDTO> getApplicationByID(@RequestParam long id){
        log.info("Entering [getApplicationByID] with ID = " + id);
        var response = studentApplicationService.getApplicationByID(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping()
    public ResponseEntity<List<StudentApplicationDTO>> getAllApplication(){
        log.info("Entering [getApplicationByID]");
        var response = studentApplicationService.getAllApplications();
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<StudentApplicationDTO> addNewApplication(@RequestBody StudentApplicationCreateDTO studentApplicationDTO){
        log.info("Entering [getApplicationByID]");
        var response = studentApplicationService.addNewApplication(studentApplicationDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<StudentApplicationDTO> cancelApplication(@RequestParam long id){
        var response = studentApplicationService.cancelApplication(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value = "/activeScheduler")
    public void activeScheduler(){
        studentApplicationService.checkStudentApplications();
    }
    @PostMapping(value = "/resetStatus")
    public void resetStatus(@RequestParam long id){
        studentApplicationService.chanceApplicationStatus(id);
    }
}
