package pl.byrka.uczelnia.model.Entity.Group;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "Group")
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
    public GroupTypeEnum type;
    @Column(name = "major", nullable = false)
    public String major;
    @Column(name = "specialization", nullable = false)
    public String specialization;
    @Column(name = "learningSchedule", nullable = false)
    public LearningscheduleEnum learningSchedule;
    @Column(name = "learningType", nullable = false)
    public LearningTypeEnum learningType;
    @Column(name = "subject", nullable = true)
    public String subject;
    @Column(name = "maxStudentCount", nullable = false)
    public int maxStudentCount;
}
