package org.example.jsonParser;

import org.example.Person;
import org.example.Phones;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    private static final String filePath = "src/JSONExample02.json";

    public static void main(String args[]) {
        try {
            String json = readFileAsString(filePath);

            String firstName = JsonToObject.func(Person.class, json).getFirstName();
            String lastName = JsonToObject.func(Person.class, json).getLastName();
            int age = JsonToObject.func(Person.class, json).getAge();
            Person person = new Person(firstName, lastName, age);
            ObjectToJson objectToJson = new ObjectToJson();
            json = objectToJson.convertToJson(person);
            System.out.println(json);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
