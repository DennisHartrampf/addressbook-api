package de.javengers.addressbook.service;

import de.javengers.addressbook.db.UserRepository;
import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepositoryMock;

    @BeforeEach
    void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        userService = new UserService(userRepositoryMock);
    }

    @Test
    void testGetUser() throws NoSuchUserException {
        User expectedUser = new User();
        when(userRepositoryMock.findById(anyLong())).thenReturn(Optional.of(expectedUser));
        User user = userService.getUser(12L);
        assertThat(user).isEqualTo(expectedUser);
    }

    @Test
    void testGetUser_NoSuchUser() {
        assertThatThrownBy(() -> userService.getUser(12L))
            .isInstanceOf(NoSuchUserException.class)
            .hasMessage("User with userId=12 is not found");
    }
}
