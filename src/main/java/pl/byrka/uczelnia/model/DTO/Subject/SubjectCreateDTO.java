package pl.byrka.uczelnia.model.DTO.Subject;

import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;

@Getter
@Setter
public class SubjectCreateDTO {
    public long id;
    public String name;
    public int ects;
    public String type;
    public int lecturer;
}
