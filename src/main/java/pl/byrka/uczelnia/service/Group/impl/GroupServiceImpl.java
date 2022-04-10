package pl.byrka.uczelnia.service.Group.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
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

    @Override
    public List<GroupDTO> getAllGroupForYear(String year) {
        return null;
    }

    @Override
    public GroupDTO createNewgroup(GroupDTO groupDTO) {
        return null;
    }
}
