package pl.byrka.uczelnia.model.Entity.Lecturer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerUpdateEntity {
    public long id;
    public String name;
    public String surname;
    public String title;
    public String email;
}
