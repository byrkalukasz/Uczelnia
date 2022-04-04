package pl.byrka.uczelnia.model.Emuns;

import lombok.Getter;

import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.Map;

public enum GradeValueEnum {
    ndst("niedostateczna"),
    dst("dostateczna"),
    dstp("dostateczna plus"),
    db("dobry"),
    dbp("dobry Plus"),
    bdb("bdb"),
    bdbp("bdbp");

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

    public String getGradeValueEnum() {return grade;
    }

}
