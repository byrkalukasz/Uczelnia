package pl.byrka.uczelnia.repository.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
     public static String subjectList = "select s from SubjectEntity s join s.lecturer";
     public static String subjectListByLecturer = "select s from SubjectEntity s join s.lecturer l where l.id = :id";

    @Query(value = subjectList)
    List<SubjectEntity> findAll();

    @Query(value = subjectListByLecturer)
    List<SubjectEntity> findAllByLecturer(@Param("id") long id);
}
