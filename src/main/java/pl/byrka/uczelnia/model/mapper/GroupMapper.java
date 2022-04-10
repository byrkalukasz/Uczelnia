package pl.byrka.uczelnia.model.mapper;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;

@Service
public interface GroupMapper {
    GroupDTO mapFromEntity(GroupEntity src);
    GroupEntity mapFromDTO(GroupDTO src);
}
