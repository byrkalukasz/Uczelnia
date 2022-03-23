package pl.byrka.uczelnia.model.DTO.Lecturer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerDTO {
    public long id;
    public String fullName;
    public String email;
}
