package pl.byrka.uczelnia.model.DTO.Student;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDTO {
    private String name;
    private String surname;
    private long major;
    private long specialization;
}
