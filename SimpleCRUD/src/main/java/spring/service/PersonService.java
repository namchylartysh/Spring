package spring.service;

import org.springframework.stereotype.Service;
import spring.controller.PersonController;
import spring.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov"));
        persons.add(new Person("Petr", "Petrov"));
    }

    public List<Person> findAll() {
        return persons;
    }

    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        person.setId();
        persons.add(newPerson);

    }

    public void delete(Integer id) {
        Person deletePerson = null;
        for (Person person : persons) {
            if (person.getId() == id) {
                deletePerson = person;
                break;
            }
        }
        if (deletePerson != null) {
            persons.remove(deletePerson);
        }
        // removeIf(p -> p.getId() == id); другой вариант написания с помощью лямбды
    }

    public void edit(Integer id, Person person) {
        Person newPerson = persons.get(id);
        if (newPerson != null) {
            newPerson.update(person.getFirstName(), person.getLastName());
           // newPerson.setId();
            persons.set(id, newPerson);
        }
    }


    public Person getPersonById(int id) {
        Person foundPerson = null;
        for (Person person : persons) {
            if (person.getId() == id) {
                foundPerson = person;
            }
        }
        return foundPerson;
    }
}
