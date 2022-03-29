package pl.byrka.uczelnia.service.Subject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.model.mapper.SubjectMapper;
import pl.byrka.uczelnia.repository.Lecturer.LecturerRepository;
import pl.byrka.uczelnia.repository.Subject.SubjectRepository;
import pl.byrka.uczelnia.service.Subject.SubjectService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public List<SubjectDTO> getAllSubjectWithLecturer() {
        List<SubjectDTO> list = new ArrayList<>();
        var response = subjectRepository.findAll();
        for(var obj : response)
        {
            list.add(subjectMapper.mapSubjectToDTO(obj));
        }
        return list;
    }

    @Override
    public SubjectDTO createNewSubject(SubjectCreate subjectCreate) {
        var subjectEntity = subjectMapper.mapSubjectToEntity(subjectCreate);
        var response = subjectRepository.save(subjectEntity);
        var result = subjectMapper.mapSubjectToDTO(response);
        return result;
    }

    @Override
    public SubjectDTO getSubjectById(long id) {
        try {
            var response = subjectRepository.getById(id);
            var result = subjectMapper.mapSubjectToDTO(response);

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
                dst.add(subjectMapper.mapSubjectToDTO(obj));
            }
            return dst;

        } catch (Exception e) {
            throw new UczelniaException("Subject","ID",id);
        }
    }
}
