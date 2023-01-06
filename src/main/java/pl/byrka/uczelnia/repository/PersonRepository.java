package pl.byrka.uczelnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.byrka.uczelnia.model.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
