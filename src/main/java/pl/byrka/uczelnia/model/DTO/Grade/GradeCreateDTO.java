package pl.byrka.uczelnia.model.DTO.Grade;

import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Emuns.GradeStateEnum;
import pl.byrka.uczelnia.model.Emuns.GradeValueEnum;

@Getter
@Setter
public class GradeCreateDTO {
    public GradeValueEnum grade;
    public GradeStateEnum status;
    public long student;
    public long subject;
    public long lecturer;
}
