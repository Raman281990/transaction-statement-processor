package com.rabo.bank.transactions.exception;

/**
 * Custom exception thrown while exception in parsing the XML records
 */
public class XMLParsingException extends RuntimeException {

    public XMLParsingException(String message) {
        super(message);
    }

    public XMLParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
