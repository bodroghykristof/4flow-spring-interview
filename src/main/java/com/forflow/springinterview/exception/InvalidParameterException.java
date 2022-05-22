package com.forflow.springinterview.exception;

public class InvalidParameterException extends RuntimeException {

    private static final long serialVersionUID = 8636324146188732010L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
