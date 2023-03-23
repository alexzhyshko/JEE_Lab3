package com.example.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeRate {

    private UUID id;
    private float rate;
    private Currency currency;
}
