package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationStatusEnum {
    CANCELED("Canceled"),
    NEW("New"),
    REJECTED("Rejected"),
    DONE("Done");

    private final String status;

    private static final Map<String, ApplicationStatusEnum> byGrade = new HashMap<>();

    private ApplicationStatusEnum(String status)
    {
        this.status = status;
    }
    static {
        for(ApplicationStatusEnum e: values()){
            byGrade.put(e.status, e);
        }
    }
    public static ApplicationStatusEnum valueOfLabel(String e){
        return byGrade.get(e);
    }
    @JsonValue
    public String getApplicationStatusEnum() {
        return status;
    }

}
