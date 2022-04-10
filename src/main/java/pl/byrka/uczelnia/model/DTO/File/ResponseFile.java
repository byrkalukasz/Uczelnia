package pl.byrka.uczelnia.model.DTO.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Emuns.DocumentTypeEnum;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFile {
    private long id;
    private String name;
    private String url;
    private DocumentTypeEnum type;
    private long size;
}
