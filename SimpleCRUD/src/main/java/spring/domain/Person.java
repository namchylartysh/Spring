package spring.domain;

import spring.service.PersonService;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private static int counter = 0;
    private static int count = 0;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++counter;
    }

    public Person() {
      // this.id = Person.this.getId();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int setId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
