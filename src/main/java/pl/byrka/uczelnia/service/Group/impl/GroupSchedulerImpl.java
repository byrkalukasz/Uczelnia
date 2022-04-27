package pl.byrka.uczelnia.service.Group.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Group.GroupAutoCreateDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.repository.Major.MajorRepository;
import pl.byrka.uczelnia.repository.Specialization.SpecializationRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.repository.StudentGroup.StudentGroupRepository;
import pl.byrka.uczelnia.service.Group.GroupScheduler;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupSchedulerImpl implements GroupScheduler {
    private final StudentGroupRepository studentGroupRepository;
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;
    private final SpecializationRepository specializationRepository;

    public GroupSchedulerImpl(StudentGroupRepository studentGroupRepository, StudentRepository studentRepository, MajorRepository majorRepository, SpecializationRepository specializationRepository) {
        this.studentGroupRepository = studentGroupRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public void autoCreateGroup(GroupAutoCreateDTO autoCreateDTO) {

        switch (GroupTypeEnum.valueOf(autoCreateDTO.getType()))
        {
            case WYK:
            case KON:
                createMajorGroup(autoCreateDTO.getYear());
            case CW:
            case LAB:
                createSpecializationGroup(autoCreateDTO.getYear());
        }
    }

    @Override
    public void createMajorGroup(String year) {
        var majorList = checkForMajor(year);
        for(var obj : majorList){
            String name = obj.getStartYear() +"_"+obj.getName()+obj.getType()+"_"+obj.getSchedule();
            GroupEntity group = new GroupEntity();
            group.setStartYear(obj.getStartYear());
            group.setFullName(name);
            group.setLearningSchedule(obj.getSchedule());
            group.setMaxStudentCount(0);

            group.setMajor(obj);
            group.setSpecialization(null);
            System.out.println(group.getFullName());
            System.out.println(group);
        }
    }

    @Override
    public void createSpecializationGroup(String year) {

    }
    private List<MajorEntity> checkForMajor(String year){
        //TODO: poprawić zapytanie z 2 na 1 query
        var majorWithoutGroup = studentRepository.fingAllMajorsInStudentWithoutGroup();
        var majorInYear = majorRepository.findAllByStartYear(year);
        List<Long> test = new ArrayList<>();
        List<MajorEntity>majorToCreate = new ArrayList<>();
        for(var obj : majorInYear){
            if(test.contains(obj.getId())){
                continue;
            }else{
                test.add(obj.getId());
            }
        }
        for(Long id : majorWithoutGroup){
            if(test.contains(id)){
                var major = majorRepository.getById(id);
                if(majorToCreate.contains(major)){
                    continue;
                }else{
                    majorToCreate.add(major);
                }
            }
        }
        System.out.println(test);
        return majorToCreate;
    }
}
