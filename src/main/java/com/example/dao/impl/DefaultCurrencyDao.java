package com.example.dao.impl;

import java.util.Optional;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.example.dao.Dao;
import com.example.dto.Currency;
import com.example.exception.DuplicateCurrencyException;

@Singleton
@LocalBean
public class DefaultCurrencyDao extends Dao<UUID, Currency> {

    @Override
    public void save(UUID id, Currency item) {
        if(findByCode(item.getCode()).isPresent()) {
            throw new DuplicateCurrencyException("Currency for code: "+item.getCode()+" already exists");
        }
        items.put(id, item);
    }

    public Optional<Currency> findByCode(String code) {
        return items.values()
                .stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst();
    }

}
