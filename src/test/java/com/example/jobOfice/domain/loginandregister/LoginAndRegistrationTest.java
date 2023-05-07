package com.example.jobOfice.domain.loginandregister;

import com.example.jobOfice.domain.loginandregister.dto.UserDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LoginAndRegistrationTest {
    LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(
      new InMemoryUserRepository()
    );
    @Test
    public void it_should_throw_an_exception_when_user_not_found() {
        //given
        String name ="jan";
        //when

        //then
        assertThatThrownBy(() -> loginAndRegisterFacade.getUserByName(name))
                .isInstanceOf(UserNotFoundException.class);
    }
    @Test
    public void should_find_user_by_user_name() {
        //given
        String name ="Dawid";
        //when
        UserDto resault = loginAndRegisterFacade.getUserByName(name);
        //then
        assertThat(resault.userName()).isEqualTo(name);
    }



    @Test
    public void should_register_user(){
        //given
        UserDto userDto= UserDto.builder()
                .userId("4")
                .userName("tomasz")
                .password("123456")
                .build();
        //when
        loginAndRegisterFacade.addNewUser(userDto);

        //then
        assertThat(loginAndRegisterFacade.getUserByName(userDto.userName())).isEqualTo(userDto);

    }

}
