package de.javengers.addressbook.controller;

import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.ErrorMessage;
import de.javengers.addressbook.model.User;
import de.javengers.addressbook.service.AddressBookService;
import de.javengers.addressbook.service.UserService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class AddressBookController {

    private final UserService userService;
    private final AddressBookService addressBookService;

    public AddressBookController(UserService userService, AddressBookService addressBookService) {
        this.userService = userService;
        this.addressBookService = addressBookService;
    }

    @PostMapping(path = "/api/addressbook", 
                 produces = MediaType.APPLICATION_JSON_VALUE, 
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAddressBookEntry(@RequestHeader Long userId, @RequestBody AddressBookEntry entry) {
        try {
            return tryCreateAddressBookEntry(userId, entry);
        } catch (NoSuchUserException ex) {
            return noSuchUserResponse(userId);
        }
    }

    private ResponseEntity<Void> tryCreateAddressBookEntry(Long userId, AddressBookEntry entry)
    throws NoSuchUserException {
        final User user = userService.getUser(userId);
        final Long addressBookEntryId = addressBookService.createAddressBookEntry(user, entry);
        return ResponseEntity.created(URI.create(String.format("/api/addressbook/%d",
                                                               addressBookEntryId))).build();
    }

    private ResponseEntity<ErrorMessage> noSuchUserResponse(Long userId) {
        return ResponseEntity.status(400)
                             .body(new ErrorMessage(String.format("User with userId=%s is not found.", userId)));
    }

}
