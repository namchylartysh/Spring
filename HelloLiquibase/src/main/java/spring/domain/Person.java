package spring.domain;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="position_id")
    private Position position;

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
