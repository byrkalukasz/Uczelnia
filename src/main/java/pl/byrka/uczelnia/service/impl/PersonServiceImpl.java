package pl.byrka.uczelnia.service.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.PersonDTO;
import pl.byrka.uczelnia.model.Entity.Person;
import pl.byrka.uczelnia.repository.PersonRepository;
import pl.byrka.uczelnia.service.PersonService;

import static pl.byrka.uczelnia.model.mapper.impl.PersonMapper.mapPersonFromDto;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person addNewPerson(PersonDTO personDTO) {
        if (personDTO.getId() > 1)
            throw new RuntimeException("Person id must be < 1");
        var checkPerson = checkIfPersonExist(personDTO.getPESEL());
        if (checkPerson != null)
            return checkPerson;
        else
        return personRepository.save(mapPersonFromDto(personDTO));
    }

    private Person checkIfPersonExist(String pesel){
        var person = personRepository.findByPESEL(pesel);
        if (person.isPresent())
            return person.get();
        else
            return null;
    }
}
