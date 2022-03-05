package com.esgi.trademe.kernel.exceptions;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(Long id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id));
    }
}