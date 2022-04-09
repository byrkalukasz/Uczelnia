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
    public long id;
    @Column(name = "FullName",nullable = false)
    public String fullName;
    @Column(name = "ShortName", nullable = false)
    public String shortName;
    @Column(name = "StartYear", nullable = false)
    public String StartYear;
    @Column(name = "type", nullable = false)
    public String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "major_id", referencedColumnName = "id", nullable = true)
    public MajorEntity major;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialization_id", referencedColumnName = "id", nullable = true)
    public SpecializationEntity specialization;
    @Column(name = "learningSchedule", nullable = false)
    public String learningSchedule;
    @Column(name = "learningType", nullable = false)
    public String learningType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = true)
    public SubjectEntity subject;
    @Column(name = "maxStudentCount", nullable = false)
    public int maxStudentCount;

    @ManyToMany(mappedBy = "group")
    private List<StudentGroupEntity> studentGroup;
}
