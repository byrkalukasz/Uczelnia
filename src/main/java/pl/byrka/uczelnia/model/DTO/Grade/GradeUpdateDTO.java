package pl.byrka.uczelnia.model.DTO.Grade;

import lombok.*;
import pl.byrka.uczelnia.model.Emuns.GradeStateEnum;
import pl.byrka.uczelnia.model.Emuns.GradeValueEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeUpdateDTO {
    public long id;
    public GradeValueEnum grade;
    public GradeStateEnum status;
    public long student;
    public long subject;
    public long lecturer;
}
