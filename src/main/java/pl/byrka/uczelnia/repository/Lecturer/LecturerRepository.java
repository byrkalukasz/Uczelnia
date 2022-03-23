package pl.byrka.uczelnia.repository.Lecturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

@Repository
public interface LecturerRepository extends JpaRepository<LecturerEntity, Long> {

}
