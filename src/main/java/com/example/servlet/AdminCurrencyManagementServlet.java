package com.example.servlet;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constant.Constants;
import com.example.dto.FormAction;
import com.example.service.CurrencyService;

public class AdminCurrencyManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    CurrencyService currencyService;

    public AdminCurrencyManagementServlet() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = Optional.ofNullable(request.getParameter("id"))
            .map(str -> UUID.fromString(str))
            .orElse(UUID.randomUUID());
        String code = request.getParameter("code");
        FormAction action = Enum.valueOf(FormAction.class, request.getParameter("action").toUpperCase());

        if(Constants.ADMIN_ROLE.equals(request.getSession().getAttribute(Constants.ROLE_SESSSION_ATTRIBUTE))) {
            switch (action) {
            case EDIT:
                currencyService.editCurrencyById(id, code);
                break;
            case DELETE:
                currencyService.deleteCurrencyById(id);
                break;
            case CREATE:
                currencyService.createCurrency(id, code);
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