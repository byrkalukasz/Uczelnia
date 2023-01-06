package pl.byrka.uczelnia.model.DTO.Student;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.PersonDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDTO {
//    private String name;
//    private String surname;
    private PersonDTO person;
    private Long major;
    private Long specialization;
}
