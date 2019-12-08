package com.deneme.Korku.Hikayeleri.exception;

public class UserServiceException extends RuntimeException {

    private static final long SerialID = 1L;

    public UserServiceException(String message) {
        super(message);
    }
}
