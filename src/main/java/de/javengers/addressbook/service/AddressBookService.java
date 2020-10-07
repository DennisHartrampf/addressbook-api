package de.javengers.addressbook.service;

import de.javengers.addressbook.db.AddressBookEntryRepository;
import de.javengers.addressbook.db.AddressBookRepository;
import de.javengers.addressbook.db.CategoryRepository;
import de.javengers.addressbook.db.PostalAddressRepository;
import de.javengers.addressbook.exception.MultipleAddressBooksException;
import de.javengers.addressbook.model.AddressBook;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {
    private CategoryRepository categoryRepository;
    private PostalAddressRepository postalAddressRepository;
    private AddressBookEntryRepository addressBookEntryRepository;
    private AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookService(CategoryRepository categoryRepository, PostalAddressRepository postalAddressRepository, AddressBookEntryRepository addressBookEntryRepository, AddressBookRepository addressBookRepository) {
        this.categoryRepository = categoryRepository;
        this.postalAddressRepository = postalAddressRepository;
        this.addressBookEntryRepository = addressBookEntryRepository;
        this.addressBookRepository = addressBookRepository;
    }

    public Long createAddressBookEntry(User user, AddressBookEntry entry) throws MultipleAddressBooksException {
        List<AddressBook> addressBooks = addressBookRepository.findByUser(user.getId());
        AddressBook addressBook = getAddressBook(user, addressBooks);
        categoryRepository.saveAll(entry.getCategories());
        postalAddressRepository.saveAll(entry.getPostalAddress());
        entry = addressBookEntryRepository.save(entry);
        addressBook.setEntries(List.of(entry));
        addressBookRepository.save(addressBook);
        return entry.getId();
    }

    private AddressBook getAddressBook(User user, List<AddressBook> addressBooks) throws MultipleAddressBooksException {
        AddressBook addressBook = new AddressBook();
        if (addressBooks.isEmpty()) {
            addressBook.setUser(user);
            addressBook = addressBookRepository.save(addressBook);
        } else if (addressBooks.size() > 1) {
            throw new MultipleAddressBooksException(String.format("There are already %d AddressBooks for the user %s exist.", addressBooks.size(), user.getId()));
        } else {
            addressBook = addressBooks.get(0);
        }
        return addressBook;
    }
}
