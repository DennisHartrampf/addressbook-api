package de.javengers.addressbook.service;

import de.javengers.addressbook.db.UserRepository;
import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long userId) throws NoSuchUserException {
        return userRepository
                   .findById(userId)
                   .orElseThrow(() -> new NoSuchUserException(String.format(
                       "User with userId=%s is not found",
                       userId)));

    }
}
