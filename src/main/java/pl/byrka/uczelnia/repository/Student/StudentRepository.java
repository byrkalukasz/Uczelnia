package pl.byrka.uczelnia.repository.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    String query = "SELECT m.id FROM StudentEntity s JOIN s.major m WHERE s.active = 1 AND s.id NOT IN " +
            "(SELECT st.id FROM StudentGroupEntity sg JOIN sg.student st JOIN sg.group g)";

    @Query(query)
    public List<Long> fingAllMajorsInStudentWithoutGroup();
}
