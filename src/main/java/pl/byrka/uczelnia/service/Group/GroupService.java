package pl.byrka.uczelnia.service.Group;

import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> getAllGroup();
    List<GroupDTO> getAllGroupForYear(String year);
    GroupDTO createNewgroup(GroupDTO groupDTO);
    int createGroups(String type);
}
