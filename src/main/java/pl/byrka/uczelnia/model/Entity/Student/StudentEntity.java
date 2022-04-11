package pl.byrka.uczelnia.model.Entity.Student;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;

import javax.persistence.*;
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
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "active", nullable = false)
    private boolean active;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    private MajorEntity major;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private SpecializationEntity specialization;

    @ManyToMany(mappedBy = "student")
    private List<GradeEntity> grade;
    @ManyToMany(mappedBy = "student")
    private List<StudentGroupEntity> studentGroup;
    @ManyToMany(mappedBy = "student")
    private List<DocumentEntity> document;
}
