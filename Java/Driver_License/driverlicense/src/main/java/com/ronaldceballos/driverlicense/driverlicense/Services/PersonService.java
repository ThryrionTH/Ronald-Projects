package com.ronaldceballos.driverlicense.driverlicense.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.driverlicense.driverlicense.Models.Person;
import com.ronaldceballos.driverlicense.driverlicense.Repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public List<Person> getAllPersonsWithoutLicense() {
        return personRepository.findByLicenseIsNull();
    }
    
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
