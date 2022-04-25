package pl.byrka.uczelnia.repository.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    String findAllMajorWithoutGroup = "SELECT m.id FROM MajorEntity m WHERE m.id NOT IN" +
            "(SELECT m.id FROM GroupEntity ge JOIN ge.major m)";

    @Query(findAllMajorWithoutGroup)
    public List<Long> findAllMajorWithoutGroup();
}
