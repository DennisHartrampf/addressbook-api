package de.javengers.addressbook.service;

import de.javengers.addressbook.db.AddressBookEntryRepository;
import de.javengers.addressbook.db.CategoryRepository;
import de.javengers.addressbook.db.PostalAddressRepository;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {
    private CategoryRepository categoryRepository;
    private PostalAddressRepository postalAddressRepository;
    private AddressBookEntryRepository addressBookEntryRepository;

    @Autowired
    public AddressBookService(CategoryRepository categoryRepository, PostalAddressRepository postalAddressRepository, AddressBookEntryRepository addressBookEntryRepository) {
        this.categoryRepository = categoryRepository;
        this.postalAddressRepository = postalAddressRepository;
        this.addressBookEntryRepository = addressBookEntryRepository;
    }

    public Long createAddressBookEntry(User user, AddressBookEntry entry) {
        return 1L;
    }
}
