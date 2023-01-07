package pl.byrka.uczelnia.model.DTO.Student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.DTO.PersonDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;

import javax.persistence.Column;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("person")
    private PersonDTO person;
    @JsonProperty("creationDate")
    private ZonedDateTime creationDate;
    @JsonProperty("modificationDate")
    private ZonedDateTime modificationDate;
    @JsonProperty("modificationEmployeeId")
    private Long modificationEmployeeId;
    @JsonProperty("active")
    public boolean active;
    @JsonProperty("major")
    private MajorDTO major;
    @JsonProperty("specialization")
    private SpecializationDTO specialization;
}
