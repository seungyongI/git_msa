package com.lsy.org.error;

public class JwtAuthException extends RuntimeException {

    public JwtAuthException(String message) {
        super(message);
    }
}
