package pl.byrka.uczelnia.repository.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}
