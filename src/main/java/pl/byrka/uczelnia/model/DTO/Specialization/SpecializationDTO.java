package pl.byrka.uczelnia.model.DTO.Specialization;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDTO {
    public Long id;
    public String name;
    public boolean active;
}