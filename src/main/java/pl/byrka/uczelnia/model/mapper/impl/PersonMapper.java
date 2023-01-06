package pl.byrka.uczelnia.model.mapper.impl;

import pl.byrka.uczelnia.model.DTO.PersonDTO;
import pl.byrka.uczelnia.model.Entity.Person;

public class PersonMapper {

    public static Person mapPersonFromDto(PersonDTO person){
        return Person.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .dateOfBirth(person.getDateOfBirth())
                .PESEL(person.getPESEL())
                .build();
    }

    public static PersonDTO mapPersonToDto(Person person){
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .dateOfBirth(person.getDateOfBirth())
                .PESEL(person.getPESEL())
                .build();
    }
}
