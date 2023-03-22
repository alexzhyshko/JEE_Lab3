package com.example.dao.impl;

import com.example.dao.Dao;
import com.example.dto.Currency;
import com.example.dto.ExchangeDate;
import com.example.dto.ExchangeRate;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Singleton
@LocalBean
public class DefaultExchangeDateDao extends Dao<String, Currency> {

    public List<ExchangeRate> findExchangeRatesForCurrency(Currency currency, LocalDate startDate, LocalDate endDate) {
        return Arrays.asList(ExchangeRate.builder()
                        .rate(37.1f)
                        .currency(new Currency(UUID.randomUUID(), "USD"))
                        .build(),
                ExchangeRate.builder()
                        .rate(36.6f)
                        .currency(new Currency(UUID.randomUUID(), "USD"))
                        .build());
    }

    public List<ExchangeDate> findByDate(LocalDate date) {
        return Arrays.asList(ExchangeDate.builder()
                        .id(UUID.randomUUID())
                        .date(LocalDate.now())
                        .rate(ExchangeRate.builder()
                                .rate(36.6f)
                                .currency(new Currency(UUID.randomUUID(), "USD"))
                                .build())
                        .build(),
                ExchangeDate.builder()
                        .id(UUID.randomUUID())
                        .date(LocalDate.now())
                        .rate(ExchangeRate.builder()
                                .rate(40.09f)
                                .currency(new Currency(UUID.randomUUID(), "EUR"))
                                .build())
                        .build());
    }
}
