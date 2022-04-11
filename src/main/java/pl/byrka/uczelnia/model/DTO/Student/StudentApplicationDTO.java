package pl.byrka.uczelnia.model.DTO.Student;

import lombok.*;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.Emuns.ApplicationStatusEnum;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentApplicationDTO {
    private long id;
    private String name;
    private String surname;
    private String pesel;
    private ApplicationStatusEnum status;
    private String count;
    private long state;
    private String message;
    private MajorDTO major;
    private SpecializationDTO specialization;
}
