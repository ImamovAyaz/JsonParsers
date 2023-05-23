package org.example;

import java.io.Serializable;

public class Credantials implements Serializable {
    String login;
    String password;

    Credantials(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
