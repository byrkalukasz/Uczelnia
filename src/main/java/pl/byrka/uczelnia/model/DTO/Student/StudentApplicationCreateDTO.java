package pl.byrka.uczelnia.model.DTO.Student;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.Emuns.ApplicationStatusEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentApplicationCreateDTO {
    private String name;
    private String surname;
    private String pesel;
    private ApplicationStatusEnum status;
    private String count;
    private long major;
    private long specialization;
}
