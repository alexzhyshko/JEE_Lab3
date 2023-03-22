package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Currency curr1 = new Currency("USD", "38.9");
//        Currency curr2 = new Currency("EUR", "40.1");
//        Currency[] currencies = List.of(curr1, curr2).toArray(new Currency[] {});
//
//        request.setAttribute("today", Timestamp.valueOf(LocalDateTime.now()));
//        request.setAttribute("currencies", currencies);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/curr.jsp");

        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
