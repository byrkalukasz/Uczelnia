package pl.byrka.uczelnia.service.Group;

import pl.byrka.uczelnia.model.DTO.Group.GroupAutoCreateDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;

public interface GroupScheduler {
    void autoCreateGroup(GroupAutoCreateDTO autoCreateDTO);
    void createMajorGroup(String year);
    void createSpecializationGroup(String year);
}
