package com.example.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Currency {

    private UUID id;
    private String code;

}
