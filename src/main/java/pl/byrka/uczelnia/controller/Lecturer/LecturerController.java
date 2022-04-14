package pl.byrka.uczelnia.controller.Lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerCreateDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerUpdateDTO;
import pl.byrka.uczelnia.service.Lecturer.LecturerService;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<LecturerDTO>> getLecturerById(@PathVariable("id") long id)
    {
        var response = lecturerService.getLecturerFromId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LecturerDTO>> getAllLecturers()
    {
        var lecturersList = lecturerService.getAllLecturer();
        return new ResponseEntity<List<LecturerDTO>>(lecturersList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LecturerDTO> createLecturer(@RequestBody LecturerCreateDTO lecturerCreate)
    {
        var created = lecturerService.createLecturer(lecturerCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<LecturerDTO> updateLecturer(@RequestBody LecturerUpdateDTO lecturerUpdate)
    {
        var updatedLecturer = lecturerService.updateLecturer(lecturerUpdate);
        return new ResponseEntity<>(updatedLecturer, HttpStatus.OK);
    }

}
