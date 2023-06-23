package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.jsonParser.JsonElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    transient int id;
    @JsonElement()
    private String firstName;
    @JsonElement()
    private String lastName;
    @JsonElement()
    private int age;
    private List<Phones> phoneNumbers = new ArrayList<>();
    private List<Person> friends = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setLastName(int age) {
        this.age = age;
    }

    public List<Person> getFriends() {
        List<Person> friends = new ArrayList<>(this.friends);
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends.addAll(friends);
    }

    public List<Phones> getPhoneNumber() {
        List<Phones> phone = new ArrayList<>(this.phoneNumbers);
        return phone;
    }

    public void setPhoneNumber(List<Phones> phoneNumbers) {
        this.phoneNumbers.addAll(phoneNumbers);
    }
}
