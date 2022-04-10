package pl.byrka.uczelnia.service.File;

import org.springframework.web.multipart.MultipartFile;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

public interface FileService {
    DocumentEntity saveDocument(MultipartFile file, String type, long student_id) throws IOException;
    DocumentEntity getFileById(long id);
}
