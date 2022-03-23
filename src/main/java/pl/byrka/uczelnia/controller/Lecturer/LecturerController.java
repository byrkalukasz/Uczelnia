package pl.byrka.uczelnia.controller.Lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerCreateEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerUpdateEntity;
import pl.byrka.uczelnia.service.Lecturer.LecturerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lecturer")
public class LecturerController {
    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService)
    {
        super();
        this.lecturerService = lecturerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LecturerDTO> getLecturerById(@PathVariable("id") long id)
    {
        var lecturer = lecturerService.getLecturerFromId(id);
        return new ResponseEntity<LecturerDTO>(lecturer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LecturerDTO>> getAllLecturers()
    {
        var lecturersList = lecturerService.getAllLecturer();
        return new ResponseEntity<List<LecturerDTO>>(lecturersList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LecturerDTO> createLecturer(@RequestBody LecturerCreateEntity lecturerCreate)
    {
        var created = lecturerService.createLecturer(lecturerCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<LecturerDTO> updateLecturer(@RequestBody LecturerUpdateEntity lecturerUpdate)
    {
        var updatedLecturer = lecturerService.updateLecturer(lecturerUpdate);
        return new ResponseEntity<>(updatedLecturer, HttpStatus.OK);
    }

}
