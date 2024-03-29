package pl.byrka.uczelnia.controller.Specialization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.service.Specialization.SpecializationService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/specialization")
public class SpecializationController {
    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }
    @GetMapping("{id}")
    public ResponseEntity<SpecializationDTO> getSpecializationById(@PathVariable("id") long id){
        return specializationService.getSpecializationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<SpecializationDTO>> getAllSpecialization(){
        log.info("Entering [getSpecializationById]");
        var result = specializationService.getAllSpecializations();
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<SpecializationDTO> createSpecialization(@Valid @RequestBody SpecializationDTO specializationCreateDTO){
        log.info("Entering [createSpecialization]");
        return specializationService.addSpecialization(specializationCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
