package pl.byrka.uczelnia.repository.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;

import java.util.List;

public interface DocumentRepository extends JpaRepository<DocumentEntity,Long> {

    @Query(value = "SELECT d FROM DocumentEntity d JOIN FETCH d.studentApplication s WHERE s.id = :id")
    List<DocumentEntity> getAllDocumentsForApplication(@Param("id") long id);
}
