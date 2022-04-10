package pl.byrka.uczelnia.model.DTO.Major;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTO {
    public long id;
    public String name;
    public boolean active;
}
