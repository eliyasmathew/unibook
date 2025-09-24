package com.unibooking.backend.Exception;

public class ProviderAlreadyExists extends RuntimeException {
    public ProviderAlreadyExists(String message) {
        super(message);
    }
}
