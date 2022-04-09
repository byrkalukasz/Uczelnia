package pl.byrka.uczelnia.service.Specialization.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Specialization.SpecializationDTO;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.mapper.SpecializationMapper;
import pl.byrka.uczelnia.repository.Specialization.SpecializationRepository;
import pl.byrka.uczelnia.service.Specialization.SpecializationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationMapper specializationMapper;
    private final SpecializationRepository specializationRepository;

    public SpecializationServiceImpl(SpecializationMapper specializationMapper, SpecializationRepository specializationRepository) {
        this.specializationMapper = specializationMapper;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public List<SpecializationDTO> getAllSpecializations() {
        var response = specializationRepository.findAll();
        List<SpecializationDTO> result = new ArrayList<>();
        for(var obj : response){
            result.add(specializationMapper.mapFromEntity(obj));
        }
        return result;
    }

    @Override
    public SpecializationDTO getSpecializationById(long id) {
        var response = specializationRepository.getById(id);
        return specializationMapper.mapFromEntity(response);
    }

    @Override
    public SpecializationDTO addSpecialization(SpecializationCreateDTO specializationCreateDTO) {
        var send = specializationMapper.mapFromCreate(specializationCreateDTO);
        var response = specializationRepository.save(send);
        return specializationMapper.mapFromEntity(response);

    }

    @Override
    public SpecializationDTO updateSpecialization(SpecializationDTO specializationDTO) {
        SpecializationEntity existingSpecialization = specializationRepository.findById(specializationDTO.getId())
                .orElseThrow(() -> new UczelniaException("Specialization","id", specializationDTO.getId())
                );
        existingSpecialization.setActive(specializationDTO.isActive());
        existingSpecialization.setName(specializationDTO.getName());

        specializationRepository.save(existingSpecialization);

        return specializationMapper.mapFromEntity(existingSpecialization);
    }
}
