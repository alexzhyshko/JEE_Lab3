package com.example.dto;

public class Currency {

    private String name;
    private String rate;


    public Currency(String name, String rate) {
        this.name = name;
        this.rate = rate;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getRate() {
        return rate;
    }


    public void setRate(String rate) {
        this.rate = rate;
    }




}
