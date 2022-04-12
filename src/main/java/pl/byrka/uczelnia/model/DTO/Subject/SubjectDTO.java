package pl.byrka.uczelnia.model.DTO.Subject;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    public long id;
    public String name;
    public int ects;
    public String type;
    public LecturerDTO lecturer;
}
