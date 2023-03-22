package com.example.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constant.Constants;
import com.example.service.CurrencyService;


public class AdminConsoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    CurrencyService currencyService;

    public AdminConsoleServlet() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("todayDate", LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        request.setAttribute("currencies", currencyService.getAllCurrencies());

        request.getRequestDispatcher(Constants.ADMIN_PAGE_PATH).forward(request, response);
    }
}