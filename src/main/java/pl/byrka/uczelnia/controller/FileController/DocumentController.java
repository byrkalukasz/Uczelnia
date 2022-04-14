package pl.byrka.uczelnia.controller.FileController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.byrka.uczelnia.model.DTO.File.ResponseFile;
import pl.byrka.uczelnia.model.DTO.File.ResponseMessage;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
import pl.byrka.uczelnia.service.File.FileService;

import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/document")
public class DocumentController {
    private final FileService fileService;

    public DocumentController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    @ApiOperation(value = "Upload new document to database",
    notes = "Saving new document to database and link with student",
    response = ResponseMessage.class)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file, @RequestParam String type, @RequestParam long student_id){
        log.info("Entering [uploadFile]");
        try{
            fileService.saveDocument(file, type, student_id);
            return ResponseEntity.ok(new ResponseMessage("Plik pomyślnie wysłany"));
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body(new ResponseMessage("Wysyłanie pliku nie powiodło się!"));
        }
    }
    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFileByID(@PathVariable long id){
        log.info("Entering [getFileByID] with ID : " + id);
        DocumentEntity document = fileService.getFileById(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "arrachment; filename=\"" + document.getName() + "\"")
                .body(document.getData());

    }
}
