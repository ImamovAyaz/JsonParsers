package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.lang.reflect.Type;

public class GSON {
    public static void main(String args[]) {
        try {
            Gson g = new Gson();
            Type personTypeObj = Person.class;
            Person person = g.fromJson(new FileReader("src/JSONExample01.json"), Person.class);
            for (Person friend : person.friends) {
                System.out.print(friend.lastName);
                for (Phones phone : friend.phoneNumbers) {
                    System.out.println(" - phone type: " + phone.type + ", phone number : " + phone.number);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
