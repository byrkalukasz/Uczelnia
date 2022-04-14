package pl.byrka.uczelnia.model.DTO.Lecturer;

import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Emuns.TitleEnum;

@Getter
@Setter
public class LecturerCreateDTO {
    public String name;
    public String surname;
    public TitleEnum title;

}
