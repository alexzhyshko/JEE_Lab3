package com.example.dao.impl;

import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.example.dao.Dao;
import com.example.dto.ExchangeRate;

@Singleton
@LocalBean
public class DefaultExchangeRateDao extends Dao<UUID, ExchangeRate> {

}
