package pl.byrka.uczelnia.repository.Major;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;

public interface MajorRepository extends JpaRepository<MajorEntity, Long> {
}
