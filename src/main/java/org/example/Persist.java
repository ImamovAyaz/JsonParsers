package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// https://www.javatpoint.com/serialization-in-java
// https://www.baeldung.com/java-serialization

public class Persist {
    public static void main(String args[]) {
        try {
            /*
            // Creating the object
            Student theStudent = new Student(1,"Semenchenko");
            // Creating stream and writing the object
            FileOutputStream fOut = new FileOutputStream("studentFOut.txt");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(theStudent);
            out.flush();
            // closing the stream
            out.close();

            Credantials creds = new Credantials("login", "password");
            FileOutputStream fOutCreds = new FileOutputStream("credsFOut.txt");
            ObjectOutputStream outCreds = new ObjectOutputStream(fOutCreds);
            outCreds.writeObject(creds);
            outCreds.flush();
            outCreds.close();

             */

            Credantials creds = new Credantials("login", "password");
            Student theStudent = new Student(1, "Semenchenko", "Java QA Automation", 0, creds);
            FileOutputStream fOut = new FileOutputStream("studentFOut.txt");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(theStudent);
            out.flush();
            out.close();

            System.out.println("Success");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            /*
            // Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("studentFOut.txt"));
            Student theStudent = (Student)in.readObject();
            // printing the data of the serialized object
            System.out.println(theStudent.id + " " + theStudent.name);
            // closing the stream
            in.close();

            ObjectInputStream inCreds = new ObjectInputStream(new FileInputStream("credsFOut.txt"));
            Credantials creds = (Credantials)inCreds.readObject();
            System.out.println(creds.login + " " + creds.password);
            in.close();

             */

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("studentFOut.txt"));
            Student theStudent = (Student) in.readObject();
            System.out.println(theStudent.id + " " + theStudent.getFirstName() + " " + theStudent.course + " " + theStudent.fee);
            System.out.println(theStudent.creds.login + " " + theStudent.creds.password);
            for (String grade : theStudent.grades) {
                System.out.println(grade);
            }

            //Person somePerson = (Person) in.readObject();
            //System.out.println(somePerson.id + " " + somePerson.name);
            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
