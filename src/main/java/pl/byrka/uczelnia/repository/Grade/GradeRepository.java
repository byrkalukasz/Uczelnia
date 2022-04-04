package pl.byrka.uczelnia.repository.Grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
    String getAllForStudent = "SELECT g FROM GradeEntity g JOIN g.student s JOIN g.lecturer l JOIN g.subject u WHERE s.id = :student_id";

    @Query(value = getAllForStudent)
    List<GradeEntity> getAllGradesForUser(@Param("student_id") long student_id);
}
