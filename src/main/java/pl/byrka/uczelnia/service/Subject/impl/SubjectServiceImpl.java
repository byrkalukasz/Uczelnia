package pl.byrka.uczelnia.service.Subject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectCreateDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.repository.Subject.SubjectCreateRepository;
import pl.byrka.uczelnia.repository.Subject.SubjectRepository;
import pl.byrka.uczelnia.service.Subject.SubjectService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectCreateRepository subjectCreateRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectCreateRepository subjectCreateRepository) {
        super();
        this.subjectRepository = subjectRepository;
        this.subjectCreateRepository = subjectCreateRepository;
    }

    @Override
    public List<SubjectDTO> getAllSubjectWithLecturer() {
        List<SubjectDTO> list = new ArrayList<>();
        var response = subjectRepository.findAll();
        for(var obj : response)
        {
            list.add(mapSubjectToDTO(obj));
        }
        return list;
    }

    @Override
    public SubjectDTO createNewSubject(SubjectCreate subjectEntity) {
        var dst = mapSubjectToEntity(subjectEntity);
        var response = subjectRepository.save(dst);
        var resoult = getSubjectById(response.getId());
        return resoult;
    }

    @Override
    public SubjectDTO getSubjectById(long id) {
        var respomse = subjectRepository.getById(id);
        var resoult = mapSubjectToDTO(respomse);

        return resoult;
    }

    private SubjectDTO mapSubjectToDTO(SubjectEntity src)
    {
        SubjectDTO dts = new SubjectDTO();

        dts.setId(src.getId());
        dts.setName(src.getName());
        dts.setEcts(src.getEcts());
        dts.setType(src.getType());
        dts.setLecturer(mapLecturerFromEntiry(src.getLecturer()));
        return dts;
    }
    private SubjectCreate mapSubjectToEntity(SubjectCreate src)
    {
        SubjectCreate dst = new SubjectCreate();
        dst.setId(src.getId());
        dst.setEcts(src.getEcts());
        dst.setName(src.getName());
        dst.setType(src.getType()); //To widze do poprawy Enumy warto zapakować w osobny pakiet
        dst.setLecturer(src.getLecturer());

        return dst;
    }
    private LecturerDTO mapLecturerFromEntiry(LecturerEntity src)
    {
        LecturerDTO dst = new LecturerDTO();
        dst.setId(src.getId());
        dst.setFullName(createFullName(src.getName(), src.getSurname(), src.getTitle()));
        dst.setEmail(src.getEmail());
        return dst;
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
}
