package pl.byrka.uczelnia.model.DTO.Subject;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    public Long id;
    public String name;
    public int ects;
    public GroupTypeEnum type;
    public LecturerDTO lecturer;
}
