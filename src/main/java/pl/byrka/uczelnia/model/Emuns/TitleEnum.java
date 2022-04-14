package pl.byrka.uczelnia.model.Emuns;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TitleEnum {
    MAGISTER("Magister"),
    PROFESOR("Profesor"),
    DOKTOR("Doktor"),
    MAGISTER_INZYNIER("Magister Inżynier");

    private String title;

    private TitleEnum(String title)
    {
        this.title = title;
    }
    @JsonValue
    public String getTitleEnum(){
        return title;
    }
}
