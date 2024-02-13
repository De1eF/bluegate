package com.backend.bluegate.exception;

public class InvalidJwtAuthenticationException extends Exception {
    public InvalidJwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
