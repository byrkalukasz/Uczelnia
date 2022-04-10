package pl.byrka.uczelnia.repository.Student;

import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;

import java.util.List;

public interface StudentApplicationRepository extends JpaRepository<StudentApplicationEntity, Long> {
    String getAllActiveApplications = "SELECT s.id FROM StudentApplicationEntity s WHERE s.status = :type";

    @Query(getAllActiveApplications)
    List<Long> getAllActiveApplications(@Param("type") String type);
}
