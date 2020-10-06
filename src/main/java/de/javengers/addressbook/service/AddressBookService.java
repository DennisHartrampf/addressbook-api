package de.javengers.addressbook.service;

import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {
    public Long createAddressBookEntry(User user, List<AddressBookEntry> entries) {
        return 1L;
    }
}
