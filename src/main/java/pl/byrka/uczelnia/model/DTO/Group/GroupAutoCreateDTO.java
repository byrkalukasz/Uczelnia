package pl.byrka.uczelnia.model.DTO.Group;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupAutoCreateDTO {
    private long maxStudentCount;
    private String type;
    private String year;
}
