package de.javengers.addressbook.controller;

import de.javengers.addressbook.service.UserService;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

public class UserServiceMock {

    @Bean
    public UserService userService(){
        return mock(UserService.class);
    }
}
