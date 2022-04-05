package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;

public interface GroupMapper {
    GroupDTO mapFromEntity(GroupEntity src);
    GroupEntity mapFromDTO(GroupDTO src);
}
