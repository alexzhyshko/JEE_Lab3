package com.example.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.constant.Constants;

@Singleton
@LocalBean
public class AdminLoginService {

    public AdminLoginService() {

    }

    public String tryLogInAdmin(HttpServletRequest request, String username, String password) {
        boolean credentialsMatch = username.equals(Constants.ADMIN_USERNAME)
                && password.equals(Constants.ADMIN_PASSWORD);
        if (credentialsMatch) {
            HttpSession session = request.getSession();
            session.setAttribute(Constants.ROLE_SESSSION_ATTRIBUTE, Constants.ADMIN_ROLE);
            return request.getContextPath() + Constants.ADMIN_PAGE_URL;
        }
        return request.getContextPath() + Constants.ADMIN_LOGIN_PAGE_URL;
    }

}
