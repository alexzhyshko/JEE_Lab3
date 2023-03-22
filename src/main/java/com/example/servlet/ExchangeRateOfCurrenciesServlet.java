package com.example.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dto.ExchangeDate;
import com.example.service.CurrencyExchangeService;

@WebServlet("/home")
public class ExchangeRateOfCurrenciesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private CurrencyExchangeService currencyExchangeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ExchangeDate> exchangeDates = currencyExchangeService.getExchangeRatesForDate(LocalDate.now());
        request.setAttribute("today", Timestamp.valueOf(LocalDateTime.now()));
        request.setAttribute("exchangeDates", exchangeDates);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/curr.jsp");
        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
