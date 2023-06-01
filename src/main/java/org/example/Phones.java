package org.example;

import java.io.Serializable;

public class Phones implements Serializable {
    public String type;
    public String number;

    public Phones(String type, String number) {
        this.type = type;
        this.number = number;
    }


    public Object clonePhone() {
        return new Phones(type, number);
    }
}
