package com.rabo.bank.transactions.exception;

public class CSVGenerationException extends RuntimeException {

    public CSVGenerationException(String message) {
        super(message);
    }

    public CSVGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
