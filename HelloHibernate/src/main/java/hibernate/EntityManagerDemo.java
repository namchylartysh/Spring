package hibernate;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerDemo {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();

        Person person = new Person("Sidor", "Sidorov");

        // Открываем транзакцию
//        em.getTransaction().begin();
//        em.persist(person);
//        em.getTransaction().commit();

        // search
        em.getTransaction().begin();
        Person foundPerson = em.find(Person.class, 1);
        em.getTransaction().commit();
        System.out.println(foundPerson);

        // update / edit
        foundPerson.setLastname("Ivanovic");
        em.getTransaction().begin();
        em.merge(foundPerson);
        em.getTransaction().commit();

        // delete
        em.getTransaction().begin();
        Person removedPerson = em.find(Person.class, 3);
        em.remove(removedPerson);
        em.getTransaction().commit();



    }


}
