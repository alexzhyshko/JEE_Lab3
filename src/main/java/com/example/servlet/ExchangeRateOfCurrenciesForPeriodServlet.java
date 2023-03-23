package com.example.servlet;

import com.example.dto.ExchangeDate;
import com.example.dto.ExchangeRate;
import com.example.service.CurrencyExchangeService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/home/currencies_for_period")
public class ExchangeRateOfCurrenciesForPeriodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private CurrencyExchangeService currencyExchangeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String currencyCode = request.getParameter("currencyCode");

        LocalDate start = startDate != null ? LocalDate.parse(startDate) : null;
        LocalDate end = endDate != null ? LocalDate.parse(endDate) : null;
        List<ExchangeRate> exchangeRates = currencyExchangeService.getExchangeRatesForCurrency(currencyCode, start, end);
        request.setAttribute("exchangeRates", exchangeRates);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/currenciesForPeriod.jsp");
        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
