package org.example;


import com.alibaba.fastjson2.JSON;

import java.io.FileReader;

public class Jackson {
    public static void main(String args[]) {
        try {
            Person person = JSON.parseObject(new FileReader("src/JSONExample01.json"), Person.class);
            String jsonObject = JSON.toJSONString(person);
            Person newPerson = JSON.parseObject(jsonObject, Person.class);
            for (Person friend : newPerson.friends) {
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
