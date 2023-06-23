package org.example;

import org.example.jsonParser.JsonElement;

import java.io.Serializable;

public class Phones implements Serializable {
    @JsonElement()
    public String type;
    @JsonElement()
    public String number;

    public Phones(String type, String number) {
        this.type = type;
        this.number = number;
    }


    public Object clonePhone() {
        return new Phones(type, number);
    }
}
