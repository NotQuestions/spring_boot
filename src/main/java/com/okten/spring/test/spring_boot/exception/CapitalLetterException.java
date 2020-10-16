package com.okten.spring.test.spring_boot.exception;

public class CapitalLetterException extends RuntimeException {
    public CapitalLetterException(String s) {
        super(s);
    }
}
