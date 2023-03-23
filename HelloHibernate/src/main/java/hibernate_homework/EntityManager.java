package hibernate_homework;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class EntityManager {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate_homework.cfg.xml")
                .buildSessionFactory();

        // Из фабрики создаем EntityManager
        javax.persistence.EntityManager em = factory.createEntityManager();

        Client client = new Client("Jack", "Sparrow");

        // Открываем транзакцию
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();

        // поиск
//        em.getTransaction().begin();
//        Client foundClient = em.find(Client.class, 1);
//        em.getTransaction().commit();
//        System.out.println(foundClient);

        // редактирование
//        foundClient.setLastname("Vorobei");
//        em.getTransaction().begin();
//        em.merge(foundClient);
//        em.getTransaction().commit();

        // удаление
//        em.getTransaction().begin();
//        Client removedClient = em.find(Client.class, 3);
//        em.remove(removedClient);
//        em.getTransaction().commit();
    }


}
