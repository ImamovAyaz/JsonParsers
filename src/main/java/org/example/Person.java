package org.example;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    transient int id;
    public String firstName;
    public String lastName;
    public int age;
    public List<Phones> phoneNumbers;
    public List<Person> friends;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
