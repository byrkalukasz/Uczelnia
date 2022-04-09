package pl.byrka.uczelnia.model.DTO.Group;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

    public long id;

    public String fullName;

    public String shortName;

    public String StartYear;

    public GroupTypeEnum type;
    public MajorDTO major;
    public SpecializationDTO specialization;

    public LearningscheduleEnum learningSchedule;

    public LearningTypeEnum learningType;
    public SubjectDTO subject;

    public int maxStudentCount;
}
