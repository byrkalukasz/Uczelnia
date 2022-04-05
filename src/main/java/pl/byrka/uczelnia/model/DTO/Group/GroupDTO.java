package pl.byrka.uczelnia.model.DTO.Group;

import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

public class GroupDTO {
    public long id;
    public String fullName;
    public String shortName;
    public String StartYear;
    public GroupTypeEnum type;
    public String major;
    public String specialization;
    public LearningscheduleEnum learningSchedule;
    public LearningTypeEnum learningType;
    public SubjectEntity subject;
    public int maxStudentCount;
}
