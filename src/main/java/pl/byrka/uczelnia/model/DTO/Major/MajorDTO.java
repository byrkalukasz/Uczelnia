package pl.byrka.uczelnia.model.DTO.Major;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.LearningTypeEnum;
import pl.byrka.uczelnia.model.Emuns.LearningscheduleEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTO {
    public long id;
    public String name;
    public boolean active;
    public LearningTypeEnum type;
    public LearningscheduleEnum schedule;
    private String startYear;
}
