package pl.byrka.uczelnia.model.DTO.Lecturer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerUpdateDTO {
    public long id;
    public String name;
    public String surname;
    public String title;
    public String email;
}
