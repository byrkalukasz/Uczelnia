package pl.byrka.uczelnia.controller.Major;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.service.Major.MajorService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/major")
public class MajorController {
    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping()
    public ResponseEntity<List<MajorDTO>> getAllMajor(){
        log.info("Entering [getAllMajor]");
        var response = majorService.getAllMajor();
        return ResponseEntity.ok(response);
    }
    @GetMapping("{id}")
    public ResponseEntity<MajorDTO> getMajorById(@PathVariable long id){
        log.info("Entering [getMajorById] woth id = ",id);
        var response = majorService.getMajorById(id);
        return ResponseEntity.ok(response);
    }

}
