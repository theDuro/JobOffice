package com.example.jobOfice.domain.login;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
