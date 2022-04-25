package pl.byrka.uczelnia.model.DTO.StudentGroup;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroupDTO {
    private Long id;
    private StudentDTO student;
    private GroupDTO group;
}
