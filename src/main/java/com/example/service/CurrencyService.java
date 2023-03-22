package com.example.service;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.example.dao.impl.DefaultCurrencyDao;
import com.example.dto.Currency;
import com.example.exception.CurrencyNotFoundException;

@Singleton
@LocalBean
public class CurrencyService {

    @EJB
    DefaultCurrencyDao currencyDao;

    public void editCurrencyById(UUID id, String newCode) {
        Currency currency = currencyDao.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency for id: "+id+" not found!"));
        currency.setCode(newCode);
        //TODO uncomment when start using DAO
        //currencyDao.save(id, currency);
    }

    public void deleteCurrencyById(UUID id) {
        Currency currency = currencyDao.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency for id: "+id+" not found!"));
        currencyDao.delete(id, currency);
    }

    public void createCurrency(UUID id, String newCode) {
        Currency currency = Currency.builder().id(id).code(newCode).build();
        currencyDao.save(id, currency);
    }

    public List<Currency> getAllCurrencies() {
        return currencyDao.findAll();
    }

}
