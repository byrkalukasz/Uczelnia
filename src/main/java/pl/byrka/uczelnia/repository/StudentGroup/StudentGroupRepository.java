package pl.byrka.uczelnia.repository.StudentGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.Entity.StudentGroup.StudentGroupEntity;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroupEntity, Long> {
    String getAllForStudent = "SELECT g FROM StudentGroupEntity g JOIN g.student s JOIN g.group gr WHERE s.id = :student_id";

    @Query(value = getAllForStudent)
    List<StudentGroupEntity> getAllGroupsForStudent(@Param("student_id") long student_id);
}
