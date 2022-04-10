package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum LearningscheduleEnum {
    Z("Zaoczne"),
    S("Stacjonarne"),
    W("Wieczorowe"),
    I("Internetowe");

    private final String Learningschedule;

    private static final Map<String, LearningscheduleEnum> byType = new HashMap<>();

    private LearningscheduleEnum(String Learningschedule)
    {
        this.Learningschedule = Learningschedule;
    }
    static {
        for(LearningscheduleEnum e: values()){
            byType.put(e.Learningschedule, e);
        }
    }
    public static LearningscheduleEnum valueOfLabel(String e){
        return byType.get(e);
    }
    @JsonValue
    public String getGradeValueEnum() {
        return Learningschedule;
    }
}
