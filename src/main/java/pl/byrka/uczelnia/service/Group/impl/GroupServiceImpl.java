package pl.byrka.uczelnia.service.Group.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;
import pl.byrka.uczelnia.model.mapper.GroupMapper;
import pl.byrka.uczelnia.repository.Group.GroupRepository;
import pl.byrka.uczelnia.repository.Major.MajorRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.Group.GroupService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper, StudentRepository studentRepository, MajorRepository majorRepository) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
    }

    @Override
    public List<GroupDTO> getAllGroup() {
        var response = groupRepository.findAll();
        List<GroupDTO> result = new ArrayList<>();
        for(var obj : response){
            result.add(groupMapper.mapFromEntity(obj));
        }
        return result;
    }

    @Override
    public List<GroupDTO> getAllGroupForYear(String year) {
        return null;
    }

    @Override
    public GroupDTO createNewgroup(GroupDTO groupDTO) {
        return null;
    }

    @Override
    public int createGroups(String type) {
        switch (GroupTypeEnum.valueOf(type)){
            case WYK:
                return createWykGroup();
        }
        return 0;
    }
    private int createWykGroup(){
        //sprawdz jakie majory są przypisane do studentów ale studenci nie mają grupy
        var majorInStudentsWithoutGroup = studentRepository.fingAllMajorsInStudentWithoutGroup();
        //Dodaj Majory do listy i sprawdzaj czy major nie ma grupy
        var majorWithoutGroup = groupRepository.findAllMajorWithoutGroup();
        List<Long> majorToCreateGroup = new ArrayList<>();
        for(var obj : majorWithoutGroup){
            if(majorInStudentsWithoutGroup.contains(obj)){
                majorToCreateGroup.add(obj);
            }
        }
        //stwórz nowe grupy
        for(var obj : majorWithoutGroup ){
            var major = majorRepository.getById(obj);
            GroupEntity group = new GroupEntity();
            group.setFullName(major.getStartYear()+"_"+major.getName()+major.getType()+"_"+major.getSchedule());
            group.setShortName("TestGroupName");
            group.setMaxStudentCount(0);
            group.setMajor(major);
            group.setLearningSchedule(major.getSchedule());
            group.setStartYear(major.getStartYear());
            group.setLearningType(major.getType());
            group.setType("WYK");

            groupRepository.save(group);
        }
        //dodaj studentów

        //zwraca ilość utworzonych grup
        return 0;
    }
}
