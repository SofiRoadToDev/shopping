package com.sofi.shopping.exceptions;

public class ProductNotFoundException extends RuntimeException{
     public ProductNotFoundException(String message){
         super(message);
     }
}
