package pl.byrka.uczelnia.service.Lecturer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerCreateEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerUpdateEntity;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.repository.Lecturer.LecturerRepository;
import pl.byrka.uczelnia.service.Lecturer.LecturerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {
    private LecturerRepository lecturerRepository;
    private final LecturerMapper lecturerMapper;

    public LecturerServiceImpl(LecturerRepository lecturerRepository, LecturerMapper lecturerMapper)
    {
        this.lecturerRepository = lecturerRepository;
        this.lecturerMapper = lecturerMapper;
    }

    @Override
    public List<LecturerDTO> getAllLecturer() {
        var lecturers = lecturerRepository.findAll();
        List<LecturerDTO> lecturerDTOS = new ArrayList<>();
        for(var obj : lecturers)
        {
            lecturerDTOS.add(lecturerMapper.mapFromEntity(obj));
        }
        return lecturerDTOS;
    }

    @Override
    public LecturerDTO createLecturer(LecturerCreateEntity lecturerCreate) {
        var lecturer = lecturerMapper.mapFromCreateEntity(lecturerCreate);
        var dest = lecturerRepository.save(lecturer);
        var helper = lecturerMapper.mapFromEntity(dest);
        return helper;
    }

    @Override
    public LecturerDTO getLecturerFromId(long id) {

        var lecturer = lecturerRepository.getById(id);
        var dest = lecturerMapper.mapFromEntity(lecturer);
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

        var dst = lecturerMapper.mapFromEntity(existingLecturer);

        return dst;

    }
}
