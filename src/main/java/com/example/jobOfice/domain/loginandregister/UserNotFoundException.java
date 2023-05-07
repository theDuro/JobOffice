package com.example.jobOfice.domain.loginandregister;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User Not Found");
    }
}