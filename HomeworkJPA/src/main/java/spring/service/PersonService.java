package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public void update(Integer id, String firstName, String lastName) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person updated = person.get();
            updated.setFirstname(firstName);
            updated.setLastname(lastName);
            personRepository.save(updated);
        }
    }

    public void deleteById(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person deleted = person.get();
            personRepository.delete(deleted);
        }

    }
}
