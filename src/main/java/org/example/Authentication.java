package org.example;


public class Authentication {

    String user_name, password;

    public Authentication(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public boolean credentialCheck(String un, String p) {
        return user_name.equals(un) && password.equals(p);
    }
}

