package pl.byrka.uczelnia.model.DTO.Subject;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateDTO {
    public long id;
    public String name;
    public int ects;
    public String type;
    public int lecturer;
}
