package com.sofi.shopping.exceptions;

public class SaleNotFoundException extends RuntimeException{
    public SaleNotFoundException(String message) {
        super(message);
    }
}
