package pl.byrka.uczelnia.service.File.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
import pl.byrka.uczelnia.repository.File.DocumentRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.File.FileService;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DocumentServiceimpl implements FileService {
    private final DocumentRepository documentRepository;
    private final StudentRepository studentRepository;

    public DocumentServiceimpl(DocumentRepository documentRepository, StudentRepository studentRepository) {
        this.documentRepository = documentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public DocumentEntity saveDocument(MultipartFile file, String type, long student_id) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        var student = studentRepository.getById(student_id);
        var typeToSave = DocumentTypeEnum.valueOf(type);
        DocumentEntity documentEntity = new DocumentEntity(fileName, file.getBytes(),file.getContentType(),typeToSave.toString(),student);
        return documentRepository.save(documentEntity);
    }

    @Override
    public DocumentEntity getFileById(long id) {
        return documentRepository.getById(id);
    }
}
