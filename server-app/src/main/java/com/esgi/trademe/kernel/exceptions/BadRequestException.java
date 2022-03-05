package com.esgi.trademe.kernel.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public static BadRequestException withMessage(String message) {
        return new BadRequestException(String.format("No entity found with ID %d.", message));
    }
}

