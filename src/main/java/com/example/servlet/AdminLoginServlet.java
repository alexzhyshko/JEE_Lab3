package com.example.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constant.Constants;
import com.example.service.AdminLoginService;


public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    AdminLoginService adminLoginService;

    public AdminLoginServlet() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(Constants.LOGIN_USERNAME_PARAM);
        String password = request.getParameter(Constants.LOGIN_PASSWORD_PARAM);
        String redirectLink = adminLoginService.tryLogInAdmin(request, username, password);
        response.sendRedirect(redirectLink);
    }
}