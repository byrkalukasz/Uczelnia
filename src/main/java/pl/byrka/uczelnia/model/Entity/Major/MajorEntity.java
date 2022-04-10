package pl.byrka.uczelnia.model.Entity.Major;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;

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
    public long id;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "active", nullable = false)
    public boolean active;

    @ManyToMany(mappedBy = "major")
    private List<GroupEntity> group;
    @ManyToMany(mappedBy = "major")
    private List<StudentApplicationEntity> studentApplication;
}
