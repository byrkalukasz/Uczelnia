package pl.byrka.uczelnia.model.Entity.Lecturer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "Lecturer")
public class LecturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "name",nullable = false)
    public String name;
    @Column(name = "surname",nullable = false)
    public String surname;
    @Column(name = "title",nullable = true)
    public String title;
    @Column(name = "email",nullable = false)
    public String email;

    @OneToMany(mappedBy = "lecturer")
    private List<SubjectEntity> subjectEntities;
}
