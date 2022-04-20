package pl.byrka.uczelnia.controller.Subject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectCreate;
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
        log.info("Entering [getAllSubjectWithLectures]");
        var response = subjectService.getAllSubjectWithLecturer();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable("id") long id)
    {
        log.info("Entering [getLecturerById] with ID = {}", id);
        return subjectService.getSubjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(value = "/byLecturer/{lecturerId}")
    public ResponseEntity<List<SubjectDTO>> getAllSubjectByLecturer(@PathVariable("lecturerId") long id)
    {
        log.info("Entering [getAllSubjectByLecturer] with ID = {}", id);
        var response = subjectService.getAllSubjectByLecturer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectCreate create)
    {
        log.info("Entering [createSubject]");
        var response = subjectService.createNewSubject(create);
        log.info("Created subject with ID = {}", response.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
