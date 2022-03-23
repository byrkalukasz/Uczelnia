package pl.byrka.uczelnia.controller.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;
import pl.byrka.uczelnia.service.Subject.SubjectService;

import java.util.List;

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
    public ResponseEntity<SubjectDTO> getLecturerById(@PathVariable("id") long id)
    {
        var response = subjectService.getSubjectById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectCreate create)
    {
        var response = subjectService.createNewSubject(create);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
