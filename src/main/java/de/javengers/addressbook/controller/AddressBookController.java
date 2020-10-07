package de.javengers.addressbook.controller;

import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.ErrorMessage;
import de.javengers.addressbook.model.User;
import de.javengers.addressbook.service.AddressBookService;
import de.javengers.addressbook.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {

    private final UserService userService;
    private final AddressBookService addressBookService;

    public AddressBookController(UserService userService, AddressBookService addressBookService) {
        this.userService = userService;
        this.addressBookService = addressBookService;
    }

    @PostMapping(path = "/api/addressbook", produces = "application/json")
    public Object createAddressBook(@RequestHeader String userId, @RequestBody AddressBookEntry entry) {
        User user;
        try {
            user = userService.getUser(userId);
        } catch (NoSuchUserException ex) {
            return ResponseEntity.status(400)
                    .body(new ErrorMessage(String.format("User with userId=%s is not found.", userId)));
        }

        return addressBookService.createAddressBookEntry(user, entry);
    }

    @GetMapping(path = "/api/getjson")
    public Object getJson() {
        return List.of(new AddressBookEntry());
    }
}
