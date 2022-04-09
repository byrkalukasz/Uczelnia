package pl.byrka.uczelnia.service.Major.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Major.MajorDTO;
import pl.byrka.uczelnia.model.mapper.MajorMapper;
import pl.byrka.uczelnia.repository.Major.MajorRepository;
import pl.byrka.uczelnia.service.Major.MajorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    private final MajorRepository majorRepository;
    private final MajorMapper majorMapper;

    public MajorServiceImpl(MajorRepository majorRepository, MajorMapper majorMapper) {
        this.majorRepository = majorRepository;
        this.majorMapper = majorMapper;
    }

    @Override
    public List<MajorDTO> getAllMajor() {
        var response = majorRepository.findAll();
        List<MajorDTO> result = new ArrayList<>();
        for(var obj : response){
            result.add(majorMapper.mapFromEntity(obj));
        }
        return result;
    }

    @Override
    public MajorDTO getMajorById(long id) {
        var response = majorRepository.getById(id);
        return majorMapper.mapFromEntity(response);
    }
}
