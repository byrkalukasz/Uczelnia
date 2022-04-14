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
    public long id;
    @Column(name = "name",nullable = false)
    public String name;
    @Column(name = "surname",nullable = false)
    public String surname;
    @Column(name = "title",nullable = true)
    public String title;
    @Column(name = "email",nullable = false)
    public String email;


    @ManyToMany(mappedBy = "lecturer")
    private List<GradeEntity> grade;
    @OneToMany(mappedBy = "lecturer")
    private List<SubjectEntity> subjectEntities;
}
