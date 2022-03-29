package pl.byrka.uczelnia.model.mapper.impl;

import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerCreateEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

public class LecturerMapperImpl {
    private LecturerDTO mapFromEntity(LecturerEntity src)
    {
        LecturerDTO dest = new LecturerDTO();
        dest.setId(src.getId());
        dest.setFullName(createFullName(src.getName(), src.getSurname(), src.getTitle()));
        dest.setEmail(src.getEmail());
        return  dest;
    }
    private LecturerEntity mapFromCreateEntity(LecturerCreateEntity src)
    {
        /* Czy to jest poprawne??
        LecturerEntity dest = new LecturerEntity();
        dest.name = src.name;
        dest.surname = src.surname;
        dest.email = createEmail(src.name, src.surname);
        dest.title = src.title;
        */
        LecturerEntity dest = new LecturerEntity();
        dest.setName(src.getName());
        dest.setSurname(src.getSurname());
        dest.setEmail(createEmail(src.getName(), src.getSurname()));
        dest.setTitle(src.getTitle().getTitleEnum());
        return  dest;
    }
    private String createFullName(String name, String surname, String title)
    {
        String fullName;

        switch (title)
        {
            case "Magister":
                fullName = "mgr. " + name +" "+surname;
                break;
            case "Magister Inżynier":
                fullName = "mgr. inż. " + name +" "+surname;
                break;
            case "Doktor":
                fullName = "dr. " + name +" "+surname;
                break;
            case "Dokrot Habilitowany":
                fullName = "dr. hab.. " + name +" "+surname;
                break;
            case "Profesor":
                fullName = "prof. " + name +" "+surname;
                break;
            default:
                fullName = name +" "+surname;
        }

        return fullName;
    }
    private String createEmail(String name, String surname)
    {
        String email;
        email = name +"."+surname+"@uczelnia.pl";
        return email;
    }
}
