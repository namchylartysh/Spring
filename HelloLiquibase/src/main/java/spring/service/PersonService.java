package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.domain.Position;
import spring.repository.PersonRepository;
import spring.repository.PositionRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PositionRepository positionRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).get();
    }

    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        Position position = positionRepository.findById(1).get();
        newPerson.setPosition(position);
        personRepository.save(newPerson);
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    public void edit(Person person) {
        personRepository.save(person);
    }
}
