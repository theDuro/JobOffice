package com.example.jobOfice.domain.loginandregister;

import com.example.jobOfice.domain.loginandregister.dto.UserDto;

public class LoginAndRegisterFacade {
    private final UserRepository userRepository;

    public LoginAndRegisterFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserByName(String name){
        return null;
    }

    public void addNewUser(UserDto userDto){

    }
}
