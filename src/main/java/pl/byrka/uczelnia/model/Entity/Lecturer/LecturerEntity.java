package pl.byrka.uczelnia.model.Entity.Lecturer;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Lecturer")
public class LecturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "title",nullable = true)
    private String title;
    @Column(name = "email",nullable = false)
    private String email;


    @ManyToMany(mappedBy = "lecturer")
    private List<GradeEntity> grade;
    @OneToMany(mappedBy = "lecturer")
    private List<SubjectEntity> subjectEntities;
}
