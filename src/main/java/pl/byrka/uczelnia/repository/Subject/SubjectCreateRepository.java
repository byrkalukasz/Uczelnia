package pl.byrka.uczelnia.repository.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;

@Repository
public interface SubjectCreateRepository extends JpaRepository<SubjectCreate, Long> {
}
