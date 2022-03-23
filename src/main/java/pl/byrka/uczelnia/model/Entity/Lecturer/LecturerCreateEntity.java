package pl.byrka.uczelnia.model.Entity.Lecturer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerCreateEntity {
    public String name;
    public String surname;
    public titleEnum title;

    public enum titleEnum {
        Magister("Magister"),
        Profesor("Profesor"),
        Doktor("Doktor"),
        Magister_Inzynier("Magister Inżynier");

        private String title;

        private titleEnum(String title)
        {
            this.title = title;
        }
        public String getTitleEnum(){
            return title;
        }


    }
}
