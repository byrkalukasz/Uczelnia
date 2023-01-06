package pl.byrka.uczelnia.service;

import pl.byrka.uczelnia.model.DTO.PersonDTO;
import pl.byrka.uczelnia.model.Entity.Person;

public interface PersonService {

    Person addNewPerson(PersonDTO personDTO);
}
