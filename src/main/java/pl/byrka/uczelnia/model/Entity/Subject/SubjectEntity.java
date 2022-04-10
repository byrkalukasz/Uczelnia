package pl.byrka.uczelnia.model.Entity.Subject;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class SubjectEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "ECTS")
    private int ects;
    @Column(name = "type")
    private String type;

    @OneToOne
    @JoinColumn(name = "lecturer_id")
    private LecturerEntity lecturer;

    @ManyToMany(mappedBy = "subject")
    private List<GroupEntity> group;
    @ManyToMany(mappedBy = "subject")
    private List<GradeEntity> grade;

}
