package com.example.jobOfice.domain.loginandregister;

 interface UserRepository {
  User save(User user);
  User findByUserName(String name) throws UserNotFoundException;
}
