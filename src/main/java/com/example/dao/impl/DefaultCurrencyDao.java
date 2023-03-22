package com.example.dao.impl;

import com.example.dao.Dao;
import com.example.dto.Currency;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.util.Optional;
import java.util.UUID;

@Singleton
@LocalBean
public class DefaultCurrencyDao extends Dao<String, Currency> {
    public Optional<Currency> findByCode(String currencyCode) {
        return Optional.ofNullable(new Currency(UUID.randomUUID(), "USD"));
    }

}
