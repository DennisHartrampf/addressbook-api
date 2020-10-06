package de.javengers.addressbook.service;

import de.javengers.addressbook.db.UserRepository;
import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String userId) throws NoSuchUserException {
        try {
            return userRepository.get(userId);
        }catch (NoSuchElementException ex){
            throw new NoSuchUserException(String.format("User with userId=%s is not found", userId));
        }
    }
}
