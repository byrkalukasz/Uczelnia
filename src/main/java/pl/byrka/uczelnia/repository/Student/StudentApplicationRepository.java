package pl.byrka.uczelnia.repository.Student;

import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity;

public interface StudentApplicationRepository extends JpaRepository<StudentApplicationEntity, Long> {
}
