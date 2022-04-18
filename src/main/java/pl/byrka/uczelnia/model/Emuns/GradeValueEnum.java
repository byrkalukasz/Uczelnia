package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.Map;

public enum GradeValueEnum {
    NDST("Niedostateczna"),
    DST("Dostateczna"),
    DSTP("Dostateczna plus"),
    DB("Dobry"),
    DBP("Dobry Plus"),
    BDB("Bardzo dobry"),
    BDBP("Bardzo dobry plus");

    private final String grade;

    private static final Map<String, GradeValueEnum> byGrade = new HashMap<>();

    private GradeValueEnum(String grade)
    {
        this.grade = grade;
    }
    static {
        for(GradeValueEnum e: values()){
            byGrade.put(e.grade, e);
        }
    }
    public static GradeValueEnum valueOfLabel(String e){
        return byGrade.get(e);
    }
    @JsonValue
    public String getGradeValueEnum() {
        return grade;
    }

}
