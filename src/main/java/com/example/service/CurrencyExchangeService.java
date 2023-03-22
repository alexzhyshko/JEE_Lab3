package com.example.service;

import com.example.dao.impl.DefaultCurrencyDao;
import com.example.dao.impl.DefaultExchangeDateDao;
import com.example.dto.Currency;
import com.example.dto.ExchangeDate;
import com.example.dto.ExchangeRate;
import com.example.exception.InvalidCurrencyCodeException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class CurrencyExchangeService {

    @EJB
    private DefaultCurrencyDao currencyDao;

    @EJB
    private DefaultExchangeDateDao exchangeDateDao;

    public List<Currency> getAllCurrencies() {
        return currencyDao.findAll();
    }

    public List<ExchangeDate> getExchangeRatesForDate(LocalDate date) {
        return exchangeDateDao.findByDate(date);
    }

    public List<ExchangeRate> getExchangeRatesForCurrency(String currencyCode, LocalDate startDate, LocalDate endDate) {
        Currency currency = currencyDao.findByCode(currencyCode).orElseThrow(() ->
                new InvalidCurrencyCodeException("Can not find currency with " + currencyCode + " code"));
        return exchangeDateDao.findExchangeRatesForCurrency(currency, startDate, endDate);
    }
}
