package com.example.exception;

public class DuplicateCurrencyException extends RuntimeException{

    public DuplicateCurrencyException(String message) {
        super(message);
    }

}
