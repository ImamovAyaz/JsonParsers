package org.example;

import java.util.ArrayList;

public class Student extends Person {
    String course;
    int fee;
    Credantials creds;
    static String company = "Maxima"; // it won't be serialized
    ArrayList<String> grades;

    public Student(int id, String name, String course, int fee, Credantials creds) {
        super(id, name);

        this.course = course;
        this.fee = fee;

        this.creds = creds;

        this.grades = new ArrayList<String>();
        this.grades.add("5");
        this.grades.add("5");
        this.grades.add("5");
        this.grades.add("5");
    }
}
