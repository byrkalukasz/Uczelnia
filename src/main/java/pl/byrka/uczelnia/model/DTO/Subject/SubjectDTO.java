package pl.byrka.uczelnia.model.DTO.Subject;

import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;

@Getter
@Setter
public class SubjectDTO {
    public long id;
    public String name;
    public int ects;
    public String type;
    public LecturerDTO lecturer;
}
