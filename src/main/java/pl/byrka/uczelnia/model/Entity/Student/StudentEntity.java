package pl.byrka.uczelnia.model.Entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "surname", nullable = false)
    public String surname;
    @Column(name = "active", nullable = false)
    public boolean active;

    @ManyToMany(mappedBy = "student")
    private List<GradeEntity> grade;
}
