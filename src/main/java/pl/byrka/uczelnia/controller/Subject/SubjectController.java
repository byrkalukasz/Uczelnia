package pl.byrka.uczelnia.controller.Subject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;
import pl.byrka.uczelnia.service.Subject.SubjectService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubjectWithLectures()
    {
        var response = subjectService.getAllSubjectWithLecturer();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<SubjectDTO> getSubjectId(@PathVariable("id") long id)
    {
        log.info("Entering [getLecturerById] with ID = {}", id);
        var response = subjectService.getSubjectById(id);
        log.info("Getting response with subject ID = : {}", response.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectCreate create)
    {
        log.info("Entering [createSubject]");
        var response = subjectService.createNewSubject(create);
        log.info("Created subject with ID = {}", response.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
