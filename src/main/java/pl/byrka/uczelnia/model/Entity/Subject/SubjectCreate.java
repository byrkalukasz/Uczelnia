package pl.byrka.uczelnia.model.Entity.Subject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class SubjectCreate {
    public String name;
    public int ects;
    public typeEnum type;
    public int lecturer;

    public enum typeEnum{
        Wyklad("Wykład"),
        Cwiczenia("Ćwiczenia"),
        Lektorat("Lektorat"),
        Konwersatorium("Konwersatorium"),
        Seminarium("Seminarium");

        private String type;

        private typeEnum(String title)
        {
            this.type = title;
        }
        public String getTypeEnum(){
            return type;
        }
    }
}
