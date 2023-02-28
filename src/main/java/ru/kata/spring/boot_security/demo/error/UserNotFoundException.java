package ru.kata.spring.boot_security.demo.error;
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}

