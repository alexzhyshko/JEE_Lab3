package com.example.dao.impl;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.example.dao.Dao;
import com.example.dto.ExchangeDate;

@Singleton
@LocalBean
public class DefaultExchangeDateDao extends Dao<UUID, ExchangeDate> {

    public Optional<ExchangeDate> findForDate(LocalDate date) {
        return items.values().stream().filter(d -> d.getDate().equals(date)).findFirst();
    }

}
