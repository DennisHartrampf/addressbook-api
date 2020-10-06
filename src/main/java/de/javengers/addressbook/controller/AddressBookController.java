package de.javengers.addressbook.controller;

import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.ErrorMessage;
import de.javengers.addressbook.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    private final UserService userService;

    public AddressBookController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/api/addressbook")
    public Object createAddressBook(@RequestHeader String userId) {
        try {
            userService.getUser(userId);
        } catch (NoSuchUserException ex) {
            return ResponseEntity.status(400)
                    .body(new ErrorMessage(String.format("User with userId=%s is not found.", userId)));
        }

        return "";
    }

    private boolean validateUser(@RequestHeader String userId) {
        try {
            userService.getUser(userId);
        } catch (NoSuchUserException ex) {
            return true;
        }
        return false;
    }
}
