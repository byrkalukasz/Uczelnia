package pl.byrka.uczelnia.model.Entity.File;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Document")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Lob
    @Column(name = "data", nullable = false)
    private byte[] data;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "documenttype", nullable = false)
    private String documentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = true)
    private StudentEntity student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentApplication_id", referencedColumnName = "id", nullable = true)
    private StudentApplicationEntity studentApplication;

    public DocumentEntity(String fileName, byte[] bytes, String contentType, String type, StudentEntity student) {
        this.student = student;
        this.type = type;
        this.documentType = contentType;
        this.data = bytes;
        this.name = fileName;
    }
    public DocumentEntity(String fileName, byte[] bytes, String contentType, String type, StudentApplicationEntity student) {
        this.studentApplication = student;
        this.type = type;
        this.documentType = contentType;
        this.data = bytes;
        this.name = fileName;
    }
}
