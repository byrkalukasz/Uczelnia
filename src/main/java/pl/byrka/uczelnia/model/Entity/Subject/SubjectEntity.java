package pl.byrka.uczelnia.model.Entity.Subject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "subject")
public class SubjectEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "name",nullable = false)
    public String name;
    @Column(name = "ECTS")
    public int ects;
    @Column(name = "type")
    public GroupTypeEnum type;


    @ManyToMany(mappedBy = "subject")
    private List<GroupEntity> group;
    @ManyToMany(mappedBy = "subject")
    private List<GradeEntity> grade;

    @OneToOne
    @JoinColumn(name = "lecturer_id")
    private LecturerEntity lecturer;

}
