package pl.byrka.uczelnia.model.Entity.StudentGroup;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "StudentGroup")
public class StudentGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = true)
    private StudentEntity student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = true)
    private GroupEntity group;

}
