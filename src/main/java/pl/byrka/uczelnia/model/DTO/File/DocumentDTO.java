package pl.byrka.uczelnia.model.DTO.File;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    public long id;
    public String name;
    public String data;
    public String type;
    public DocumentTypeEnum documentType;
    public StudentDTO student;
}
