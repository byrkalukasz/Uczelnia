package pl.byrka.uczelnia.service.Group.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Group.GroupAutoCreateDTO;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.model.mapper.GroupMapper;
import pl.byrka.uczelnia.repository.Group.GroupRepository;
import pl.byrka.uczelnia.service.Group.GroupService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
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
    //TODO
    @Override
    public List<GroupDTO> getAllGroupForYear(String year) {
        return null;
    }

    @Override
    public GroupDTO createNewgroup(GroupDTO groupDTO) {
        return null;
    }

    @Override
    public void createGroups(GroupAutoCreateDTO groupAutoCreateDTO) {
        switch (GroupTypeEnum.valueOf(groupAutoCreateDTO.getType())){
            case WYK:
            case KON:
                createWykGroup(groupAutoCreateDTO.getYear());
            case CW:
            case LAB:
            case SEM:
            case SEMMAG:
                creteLabGroup(groupAutoCreateDTO.getYear(), groupAutoCreateDTO.getMaxStudentCount());
        }
    }

    private void createWykGroup(String year){
        //1. Pobranie listy majorów z roku
        //2. Sprawdzenie czy nie ma grupy dla majora w konkretnym roku
        //3. utworzenei grupy dla majowa
        //4. Dopisanie studentów do grupy
    }
    private void creteLabGroup(String year, long maxStudentCount){
        //1. Pobranie listy majorów z roku
        //2. Sprawdzenie czy nie ma grupy dla majora w konkretnym roku
        //3. utworzenei grupy dla majowa
        //4. Dopisanie studentów do grupy
    }
    private void addStudentToGroup(List<Long> studentList, long group){
        //Dla każdego elementu z listy studentó dodaj rekord

    }

}
