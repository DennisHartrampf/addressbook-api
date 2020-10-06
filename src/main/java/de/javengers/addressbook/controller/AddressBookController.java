package de.javengers.addressbook.controller;

import de.javengers.addressbook.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {


    @PostMapping(path = "/api/addressbook")
    public Object createAddressBook(@RequestHeader String userId) {
        return ResponseEntity.status(400)
                .body(new ErrorMessage(String.format("User with userId=%s is not found.", userId)));
    }
}
