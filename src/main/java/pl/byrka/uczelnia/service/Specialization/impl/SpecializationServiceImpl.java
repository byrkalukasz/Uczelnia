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
import java.util.Optional;

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
    public Optional<SpecializationDTO> getSpecializationById(long id) {
        return specializationRepository.findById(id)
                .map(specializationMapper::mapFromEntity);
    }

    @Override
    public Optional<SpecializationDTO> addSpecialization(SpecializationCreateDTO specializationCreateDTO) {
        var send = specializationMapper.mapFromCreate(specializationCreateDTO);
        var response = specializationRepository.save(send);
        return Optional.of(specializationMapper.mapFromEntity(response));

    }

    @Override
    public Optional<SpecializationDTO> updateSpecialization(SpecializationDTO specializationDTO) {
        SpecializationEntity existingSpecialization = specializationRepository.findById(specializationDTO.getId())
                .orElseThrow(() -> new UczelniaException("Specialization","id", specializationDTO.getId())
                );
        existingSpecialization.setActive(specializationDTO.isActive());
        existingSpecialization.setName(specializationDTO.getName());

        specializationRepository.save(existingSpecialization);

        return Optional.of(specializationMapper.mapFromEntity(existingSpecialization));
    }
}
