package pl.byrka.uczelnia.model.DTO.Student;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentApplicationMessage implements Serializable {
    private long id;
    private String name;
    private String surname;
    private String pesel;
    private String message;
    private long state;

}
