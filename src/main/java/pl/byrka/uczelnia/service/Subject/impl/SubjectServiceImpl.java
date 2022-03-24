package pl.byrka.uczelnia.service.Subject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.repository.Lecturer.LecturerEntityRepository;
import pl.byrka.uczelnia.repository.Subject.SubjectRepository;
import pl.byrka.uczelnia.service.Subject.SubjectService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final LecturerEntityRepository lecturerEntityRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository,  LecturerEntityRepository lecturerEntityRepository) {
        super();
        this.subjectRepository = subjectRepository;
        this.lecturerEntityRepository = lecturerEntityRepository;
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
    public SubjectDTO createNewSubject(SubjectCreate subjectCreate) {
        var subjectEntity = mapSubjectToEntity(subjectCreate);
        var response = subjectRepository.save(subjectEntity);
        var result = mapSubjectToDTO(response);
        return result;
    }

    @Override
    public SubjectDTO getSubjectById(long id) {
        try {
            var response = subjectRepository.getById(id);
            var result = mapSubjectToDTO(response);

            return result;
        } catch (Exception e) {
            throw new UczelniaException("Subject","ID",id);
        }
    }

    @Override
    public List<SubjectDTO> getAllSubjectByLecturer(long id) {
        try {
            var response = subjectRepository.findAllByLecturer(id);
            List<SubjectDTO> dst = new ArrayList<>();
            for(var obj : response)
            {
                dst.add(mapSubjectToDTO(obj));
            }
            return dst;

        } catch (Exception e) {
            throw new UczelniaException("Subject","ID",id);
        }
    }

    private SubjectEntity mapFromCreate(SubjectCreate src)
    {
        LecturerEntity lecturer = lecturerEntityRepository.getById(src.getLecturer());
        SubjectEntity dst = new SubjectEntity();
        dst.setType(src.getType().getTypeEnum());
        dst.setName(src.getName());
        dst.setEcts(src.getEcts());
        dst.setLecturer((lecturer));

        return  dst;
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
    private SubjectEntity mapSubjectToEntity(SubjectCreate src)
    {
        LecturerEntity lecturer = lecturerEntityRepository.getById(src.getLecturer());
        SubjectEntity dst = new SubjectEntity();
        dst.setEcts(src.getEcts());
        dst.setName(src.getName());
        dst.setType(src.getType().getTypeEnum());
        dst.setLecturer(lecturer);

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
