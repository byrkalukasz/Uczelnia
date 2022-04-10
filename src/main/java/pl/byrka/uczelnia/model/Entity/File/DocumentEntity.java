package pl.byrka.uczelnia.model.Entity.File;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;
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
    public long id;
    @Column(name = "name", nullable = false)
    public String name;
    @Lob
    @Column(name = "data", nullable = false)
    public byte[] data;
    @Column(name = "type", nullable = false)
    public String type;
    @Column(name = "documenttype", nullable = false)
    public String documentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public StudentEntity student;

    public DocumentEntity(String fileName, byte[] bytes, String contentType, String type, StudentEntity student) {
        this.student = student;
        this.type = type;
        this.documentType = contentType;
        this.data = bytes;
        this.name = fileName;
    }
}
