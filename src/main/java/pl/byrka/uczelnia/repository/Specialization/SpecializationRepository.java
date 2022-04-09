package pl.byrka.uczelnia.repository.Specialization;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;

public interface SpecializationRepository extends JpaRepository<SpecializationEntity, Long> {
}
