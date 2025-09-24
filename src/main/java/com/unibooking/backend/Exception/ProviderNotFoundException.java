package com.unibooking.backend.Exception;

public class ProviderNotFoundException extends RuntimeException {
    public ProviderNotFoundException(String message) {
        super(message);
    }
}
