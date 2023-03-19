package com.example.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class LoginService {

    public LoginService() {
        // TODO Auto-generated constructor stub
    }

    public boolean logIn(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return true;
        }
        return false;

    }

}
