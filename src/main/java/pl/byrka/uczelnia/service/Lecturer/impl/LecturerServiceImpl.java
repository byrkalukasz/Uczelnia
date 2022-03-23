package pl.byrka.uczelnia.service.Lecturer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerCreateEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerUpdateEntity;
import pl.byrka.uczelnia.repository.Lecturer.LecturerRepository;
import pl.byrka.uczelnia.service.Lecturer.LecturerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {
    private LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository)
    {
        super();
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<LecturerDTO> getAllLecturer() {
        var lecturers = lecturerRepository.findAll();
        List<LecturerDTO> lecturerDTOS = new ArrayList<>();
        for(var obj : lecturers)
        {
            lecturerDTOS.add(mapFromEntity(obj));
        }
        return lecturerDTOS;
    }

    @Override
    public LecturerDTO createLecturer(LecturerCreateEntity lecturerCreate) {
        var lecturer = mapFromCreateEntity(lecturerCreate);
        var dest = lecturerRepository.save(lecturer);
        var helper = mapFromEntity(dest);
        return helper;
    }

    @Override
    public LecturerDTO getLecturerFromId(long id) {

        var lecturer = lecturerRepository.getById(id);
        var dest = mapFromEntity(lecturer);
        return dest;
    }

    @Override
    public LecturerDTO updateLecturer(LecturerUpdateEntity lecturerUpdate) {
        long id = lecturerUpdate.getId();
        LecturerEntity existingLecturer = lecturerRepository.findById(id).orElseThrow(
                () -> new UczelniaException("Lecturer", "Id", id)
        );

        existingLecturer.setName(lecturerUpdate.getName());
        existingLecturer.setSurname(lecturerUpdate.getSurname());
        existingLecturer.setEmail(lecturerUpdate.getEmail());
        existingLecturer.setTitle(lecturerUpdate.getTitle());

        lecturerRepository.save(existingLecturer);

        var dst = mapFromEntity(existingLecturer);

        return dst;

    }

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
