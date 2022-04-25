package pl.byrka.uczelnia.service.Lecturer.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerCreateDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerUpdateDTO;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.repository.Lecturer.LecturerRepository;
import pl.byrka.uczelnia.service.Lecturer.LecturerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    public Optional<LecturerDTO> createLecturer(LecturerCreateDTO lecturerCreate) {
        var lecturer = lecturerMapper.mapFromCreateEntity(lecturerCreate);
        var dest = lecturerRepository.save(lecturer);
        return Optional.of(lecturerMapper.mapFromEntity(dest));
    }

    @Override
    public Optional<LecturerDTO> getLecturerFromId(long id) {

        var lecturer = lecturerRepository.findById(id);
        log.info("Find lecturer " + lecturer.toString());
        return lecturer.map(lecturerMapper::mapFromEntity);
    }

    @Override
    public Optional<LecturerDTO> updateLecturer(LecturerUpdateDTO lecturerUpdate) {
        long id = lecturerUpdate.getId();
        LecturerEntity existingLecturer = lecturerRepository.findById(id).orElseThrow(
                () -> new UczelniaException("Lecturer", "Id", id)
        );
        log.info("Find lecturer " + existingLecturer.toString());
        existingLecturer.setName(lecturerUpdate.getName());
        existingLecturer.setSurname(lecturerUpdate.getSurname());
        existingLecturer.setEmail(lecturerUpdate.getEmail());
        existingLecturer.setTitle(lecturerUpdate.getTitle());
        log.info("Update lecturer " + existingLecturer.toString());
        lecturerRepository.save(existingLecturer);
        var dst = lecturerMapper.mapFromEntity(existingLecturer);
        return Optional.of(dst);

    }
}
