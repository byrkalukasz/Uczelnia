package pl.byrka.uczelnia.controller.Lecturer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerCreateDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerUpdateDTO;
import pl.byrka.uczelnia.service.Lecturer.LecturerService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/lecturer")
public class LecturerController {
    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService)
    {
        this.lecturerService = lecturerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LecturerDTO> getLecturerById(@PathVariable("id") long id)
    {
        log.info("Getting Lecturer");
        return lecturerService.getLecturerFromId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LecturerDTO>> getAllLecturers()
    {
        log.info("Getting all Lecturer");
        var lecturersList = lecturerService.getAllLecturer();
        return new ResponseEntity<List<LecturerDTO>>(lecturersList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LecturerDTO> createLecturer(@RequestBody LecturerCreateDTO lecturerCreate)
    {
        log.info("Create Lecturer");
        return lecturerService.createLecturer(lecturerCreate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping
    public ResponseEntity<LecturerDTO> updateLecturer(@RequestBody LecturerUpdateDTO lecturerUpdate)
    {
        log.info("Update Lecturer");
        return lecturerService.updateLecturer(lecturerUpdate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
