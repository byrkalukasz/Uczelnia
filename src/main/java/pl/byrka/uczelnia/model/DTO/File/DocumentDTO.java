package pl.byrka.uczelnia.model.DTO.File;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private long id;
    private String name;
    private String data;
    private String type;
    private DocumentTypeEnum documentType;
    private StudentDTO student;
    private StudentApplicationDTO studentApplication;
}
