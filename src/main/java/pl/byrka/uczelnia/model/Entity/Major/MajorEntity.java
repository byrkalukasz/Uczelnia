package pl.byrka.uczelnia.model.Entity.Major;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Major")
public class MajorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "active", nullable = false)
    private boolean active;
    @Column(name = "type")
    private String type;
    @Column(name = "schedule")
    private String schedule;
    @Column(name = "year")
    private String startYear;
    @ManyToMany(mappedBy = "major")
    private List<GroupEntity> group;
    @ManyToMany(mappedBy = "major")
    private List<StudentApplicationEntity> studentApplication;
    @ManyToMany(mappedBy = "major")
    private List<StudentEntity> studentEntity;
}
