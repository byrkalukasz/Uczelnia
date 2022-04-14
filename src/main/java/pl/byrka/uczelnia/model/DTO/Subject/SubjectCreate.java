package pl.byrka.uczelnia.model.DTO.Subject;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreate {
    public String name;
    public int ects;
    public GroupTypeEnum type;
    public long lecturer;


}
