package com.example.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeDate {

    private UUID id;
    private List<ExchangeRate> rates;
    private LocalDate date;
}
