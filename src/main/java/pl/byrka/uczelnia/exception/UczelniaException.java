package pl.byrka.uczelnia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UczelniaException extends  RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public UczelniaException(String resourceName, String fieldName, Object fieldValue)
    {
        super(String.format("%s not found with %s : %s ", resourceName, fieldName, fieldValue ));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.resourceName = resourceName;
    }
}
