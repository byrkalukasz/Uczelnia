package pl.byrka.uczelnia.model.Entity.Group;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LearningGroup")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FullName",nullable = false)
    private String fullName;
    @Column(name = "ShortName", nullable = false)
    private String shortName;
    @Column(name = "StartYear", nullable = false)
    private String StartYear;
    @Column(name = "type", nullable = false)
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    private MajorEntity major;
    @OneToOne(cascade = CascadeType.ALL)
    private SpecializationEntity specialization;
    @Column(name = "learningSchedule", nullable = false)
    private String learningSchedule;
    @Column(name = "learningType", nullable = false)
    private String learningType;
    @OneToOne(cascade = CascadeType.ALL)
    private SubjectEntity subject;
    @Column(name = "maxStudentCount", nullable = false)
    private int maxStudentCount;

    @ManyToMany(mappedBy = "group")
    private List<StudentGroupEntity> studentGroup;
}
