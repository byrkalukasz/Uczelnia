package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum GroupTypeEnum {

    WYK("Wykłakowa"),
    CW("Ćwiczeniowa"),
    LAB("Labolatoryjna"),
    KON("Konserwatoryjna"),
    SEM("Seminarium"),
    SEMMAG("Seminarium Magisterskie");


    private final String GroupType;

    private static final Map<String, GroupTypeEnum> byType = new HashMap<>();

    private GroupTypeEnum(String GroupType)
    {
        this.GroupType = GroupType;
    }
    static {
        for(GroupTypeEnum e: values()){
            byType.put(e.GroupType, e);
        }
    }
    public static GroupTypeEnum valueOfLabel(String e){
        return byType.get(e);
    }
    @JsonValue
    public String getGrojupTypeEnum() {
        return GroupType;
    }
}
