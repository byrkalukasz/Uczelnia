package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum LearningTypeEnum {
    INZ("Inżynierskie"),
    LIC("Licencjackie"),
    MRG("Magisterskie"),
    JMG("Jednolite Magisterskie");

    private final String LearningType;

    private static final Map<String, LearningTypeEnum> byType = new HashMap<>();

    private LearningTypeEnum(String LearningType)
    {
        this.LearningType = LearningType;
    }
    static {
        for(LearningTypeEnum e: values()){
            byType.put(e.LearningType, e);
        }
    }
    public static LearningTypeEnum valueOfLabel(String e){
        return byType.get(e);
    }
    @JsonValue
    public String getLearningTypeEnum() {
        return LearningType;
    }
}
