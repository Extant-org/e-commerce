package com.ecommerce.ecommerce.resources.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException (String message) {
        super (message);
    }
}