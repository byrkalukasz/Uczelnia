package pl.byrka.uczelnia.model.DTO.Specialization;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDTO {
    public long id;
    public String name;
    public boolean active;
}