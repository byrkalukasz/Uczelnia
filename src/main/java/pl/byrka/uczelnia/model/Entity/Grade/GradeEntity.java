package pl.byrka.uczelnia.model.Entity.Grade;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.GradeStateEnum;
import pl.byrka.uczelnia.model.Emuns.GradeValueEnum;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Grade")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "grade", nullable = false)
    public String grade;
    @Column(name = "status", nullable = false)
    public String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public StudentEntity student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    public SubjectEntity subject;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    public LecturerEntity lecturer;
}
