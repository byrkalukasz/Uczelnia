package pl.byrka.uczelnia.repository.File;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;

public interface DocumentRepository extends JpaRepository<DocumentEntity,Long> {
}
