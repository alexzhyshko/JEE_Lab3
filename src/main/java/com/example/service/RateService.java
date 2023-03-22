package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.example.dao.impl.DefaultCurrencyDao;
import com.example.dao.impl.DefaultExchangeDateDao;
import com.example.dao.impl.DefaultExchangeRateDao;
import com.example.dto.Currency;
import com.example.dto.ExchangeDate;
import com.example.dto.ExchangeRate;
import com.example.exception.CurrencyNotFoundException;

@Singleton
@LocalBean
public class RateService {

    @EJB
    DefaultExchangeRateDao rateDao;
    @EJB
    DefaultCurrencyDao currencyDao;
    @EJB
    DefaultExchangeDateDao dateDao;

    public void createRateForDate(float rate, LocalDate date, String currencyCode) {
        Currency currency = currencyDao.findByCode(currencyCode)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency for code: "+currencyCode+" not found!"));

        ExchangeRate exchangeRate = ExchangeRate.builder()
                .id(UUID.randomUUID())
                .currency(currency)
                .rate(rate)
                .build();
        rateDao.save(exchangeRate.getId(), exchangeRate);

        ExchangeDate exchangeDate = dateDao.findForDate(date)
                .orElse(createNewDate(date, exchangeRate));
        if(exchangeDate.getRates() == null) {
            exchangeDate.setRates(new ArrayList<>());
        }
        exchangeDate.getRates().add(exchangeRate);
        dateDao.save(exchangeDate.getId(), exchangeDate);
    }

    private ExchangeDate createNewDate(LocalDate date, ExchangeRate exchangeRate) {
        return ExchangeDate.builder()
                .id(UUID.randomUUID())
                .date(date)
                .build();
    }

}
