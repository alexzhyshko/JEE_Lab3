package com.example.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constant.Constants;
import com.example.dto.FormAction;
import com.example.service.RateService;

public class AdminRateManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    RateService rateService;

    public AdminRateManagementServlet() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String currency = request.getParameter("currency");
        FormAction action = Enum.valueOf(FormAction.class, request.getParameter("action").toUpperCase());

        if(Constants.ADMIN_ROLE.equals(request.getSession().getAttribute(Constants.ROLE_SESSSION_ATTRIBUTE))) {
            switch (action) {
            case CREATE:
                rateService.createRateForDate(rate, date, currency);
                break;
            default:
                break;
            }
            response.sendRedirect(request.getContextPath() + Constants.ADMIN_PAGE_URL);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.HACKER_PAGE_PATH);
            rd.forward(request, response);
            System.out.println("!!!HAXING ATTEMPT!!!");
        }

    }
}