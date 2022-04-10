package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum DocumentTypeEnum {
    MAT("Swiadectwo maturalne"),
    ZYC("Życiorys"),
    PO("Pismo Ogólne"),
    PD("Podanie"),
    WPS("Wniosek o przyjęcia na studia");

    private final String type;

    private static final Map<String, DocumentTypeEnum> byGrade = new HashMap<>();

    private DocumentTypeEnum(String type)
    {
        this.type = type;
    }
    static {
        for(DocumentTypeEnum e: values()){
            byGrade.put(e.type, e);
        }
    }
    public static DocumentTypeEnum valueOfLabel(String e){
        return byGrade.get(e);
    }
    @JsonValue
    public String getDocumentTypeEnum() {
        return type;
    }

}
