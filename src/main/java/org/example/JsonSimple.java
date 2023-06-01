package org.example;

import org.example.Person;
import org.example.Phones;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonSimple {
    private static final String filePath = "src/JSONExample01.json";
    private static List<Person> friendsList = new ArrayList<>();
    private static List<Phones> phonesList = new ArrayList<>();


    public static void main(String args[]) {
        try {
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            String firstName = (String) jsonObject.get("firstName");
            String lastName = (String) jsonObject.get("lastName");
            Person person = new Person(firstName, lastName);

            JSONArray friends = (JSONArray) jsonObject.get("friends");

            Iterator friendIter = friends.iterator();
            while (friendIter.hasNext()) {
                JSONObject innerObj = (JSONObject) friendIter.next();
                JSONArray phoneNumbers = (JSONArray) innerObj.get("phoneNumbers");
                for (int i = 0; i < phoneNumbers.size(); i++) {
                    JSONObject phoneObj = (JSONObject) phoneNumbers.get(0);
                    String type = (String) phoneObj.get("type");
                    String number = (String) phoneObj.get("number");
                    phonesList.add(new Phones(type, number));
                }
                firstName = (String) innerObj.get("firstName");
                lastName = (String) innerObj.get("lastName");
                Person newPerson = new Person(firstName, lastName);
                newPerson.setPhoneNumber(phonesList);

                friendsList.add(newPerson);
                phonesList.clear();
            }
            person.setFriends(friendsList);

            JSONArray phoneNumbers = (JSONArray) jsonObject.get("phoneNumbers");
            Iterator phoneIter = phoneNumbers.iterator();
            while (phoneIter.hasNext()) {
                JSONObject innerObj = (JSONObject) phoneIter.next();
                String type = (String) innerObj.get("type");
                String number = (String) innerObj.get("number");
                phonesList.add(new Phones(type, number));
            }
            person.setPhoneNumber(phonesList);

            //Вывод данных, которые запарсили с помощью JsonSimple
            for (Person friend : person.getFriends()) {
                System.out.print(friend.getLastName());
                for (Phones phone : friend.getPhoneNumber()) {
                    System.out.println(" - phone type: " + phone.type + ", phone number : " + phone.number);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
