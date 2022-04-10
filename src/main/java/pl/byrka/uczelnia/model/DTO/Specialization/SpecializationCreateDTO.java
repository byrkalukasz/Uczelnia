package pl.byrka.uczelnia.model.DTO.Specialization;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationCreateDTO {
    public String name;
    public boolean active;
}
