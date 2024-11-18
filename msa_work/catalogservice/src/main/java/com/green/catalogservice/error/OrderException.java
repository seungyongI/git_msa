package com.green.catalogservice.error;

public class OrderException extends RuntimeException{

    public OrderException(String message) {
        super(message);
    }
}
