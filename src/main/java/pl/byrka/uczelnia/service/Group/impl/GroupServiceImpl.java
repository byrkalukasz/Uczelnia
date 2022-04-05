package pl.byrka.uczelnia.service.Group.impl;

import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.repository.Group.GroupRepository;
import pl.byrka.uczelnia.service.Group.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<GroupDTO> getAllGroup() {
        return null;
    }

    @Override
    public List<GroupDTO> getAllGroupForYear(String year) {
        return null;
    }
}
