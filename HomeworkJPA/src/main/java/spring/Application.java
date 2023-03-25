package spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.domain.Person;
import spring.service.PersonService;

/**
 * Java Professional Homework #37
 *
 * @author Artysh
 * @version 23.03 - 27.03
 */

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");

        Person person = new Person("Jack", "Sparrow");
        personService.add(person);

        Iterable<Person> persons = personService.findAll();
        System.out.println(persons);

        personService.update(2, "Nikolai", "Nikolaev");

        personService.deleteById(8);
    }
}
