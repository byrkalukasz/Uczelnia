package pl.byrka.uczelnia.model.mapper.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentApplicationDTO;
import pl.byrka.uczelnia.model.Emuns.ApplicationStatusEnum;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;
import pl.byrka.uczelnia.model.mapper.MajorMapper;
import pl.byrka.uczelnia.model.mapper.SpecializationMapper;
import pl.byrka.uczelnia.model.mapper.StudentApplicationMapper;

@Service
public class StudentApplicationMapperImpl implements StudentApplicationMapper {
    private final MajorMapper majorMapper;
    private final SpecializationMapper specializationMapper;

    public StudentApplicationMapperImpl(MajorMapper majorMapper, SpecializationMapper specializationMapper) {
        this.majorMapper = majorMapper;
        this.specializationMapper = specializationMapper;
    }

    @Override
    public StudentApplicationDTO mapFromEntity(StudentApplicationEntity src) {
        return StudentApplicationDTO.builder()
                .id(src.getId())
                .count(src.getCount())
                .major(majorMapper.mapFromEntity(src.getMajor()))
                .name(src.getName())
                .pesel(src.getPesel())
                .specialization(specializationMapper.mapFromEntity(src.getSpecialization()))
                .status(ApplicationStatusEnum.valueOf(src.getStatus()))
                .surname(src.getSurname())
                .message(src.getMessage())
                .state(src.getState())
                .build();
    }

    @Override
    public StudentApplicationEntity mapFromDTO(StudentApplicationDTO src) {
        return StudentApplicationEntity.builder()
                .id(src.getId())
                .count(src.getCount())
                .major(majorMapper.mapFromDTO(src.getMajor()))
                .name(src.getName())
                .pesel(src.getPesel())
                .specialization(specializationMapper.mapFromDTO(src.getSpecialization()))
                .status(src.getStatus().getApplicationStatusEnum())
                .surname(src.getSurname())
                .message(src.getMessage())
                .state(src.getState())
                .build();
    }

    @Override
    public StudentApplicationEntity mapFromCreate(StudentApplicationCreateDTO src, MajorEntity major, SpecializationEntity specialization) {
        return StudentApplicationEntity.builder()
                .count(src.getCount())
                .major(major)
                .name(src.getName())
                .pesel(src.getPesel())
                .specialization(specialization)
                .status(src.getStatus().toString())
                .surname(src.getSurname())
                .state(0)
                .build();
    }
}
