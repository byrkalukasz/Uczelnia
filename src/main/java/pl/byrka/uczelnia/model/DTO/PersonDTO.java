package pl.byrka.uczelnia.model.DTO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private long id;

    private String name;

    private String surname;

    private String PESEL;

    private ZonedDateTime dateOfBirth;
}
