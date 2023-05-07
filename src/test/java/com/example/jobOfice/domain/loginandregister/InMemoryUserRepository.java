package com.example.jobOfice.domain.loginandregister;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository implements UserRepository {
    Map<String,User> inMemoryDatabase =new ConcurrentHashMap<>();
    @Override
    public User save(User user) {
        inMemoryDatabase.put(user.userId(), user);
        return user;
    }

    @Override
    public User findByUserName(String name) throws UserNotFoundException {
        return inMemoryDatabase.values()
                .stream()
                .filter(user-> user.userName().equals(name))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }
}
