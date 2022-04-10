package pl.byrka.uczelnia.model.DTO.Student;

import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;

@Getter
@Setter
public class StudentDTO {
    public long id;
    public String name;
    public String surname;
    public boolean active;
    private MajorDTO major;
    private SpecializationDTO specialization;
}
