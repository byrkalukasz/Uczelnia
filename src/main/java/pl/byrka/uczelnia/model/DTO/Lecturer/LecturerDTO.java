package pl.byrka.uczelnia.model.DTO.Lecturer;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LecturerDTO {
    public long id;
    public String fullName;
    public String email;
}
