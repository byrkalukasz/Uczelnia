package pl.byrka.uczelnia.model.Entity.Student;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Person;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nrAlbumu", nullable = false)
    private boolean studentNumber;
    @Column(name = "creationDate", nullable = false)
    private ZonedDateTime creationDate;
    @Column(name = "modificationDate")
    private ZonedDateTime modificationDate;
    @Column(name = "modificationEmployeeId")
    private Long modificationEmployeeId;
    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    private MajorEntity major;
    @OneToOne(cascade = CascadeType.MERGE)
    private SpecializationEntity specialization;
    @OneToOne(cascade = CascadeType.MERGE)
    private Person person;
    @ManyToMany(mappedBy = "student")
    private List<GradeEntity> grade;
    @ManyToMany(mappedBy = "student")
    private List<StudentGroupEntity> studentGroup;
    @ManyToMany(mappedBy = "student")
    private List<DocumentEntity> document;
}
