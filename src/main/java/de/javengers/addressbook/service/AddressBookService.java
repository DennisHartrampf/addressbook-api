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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {
    private final CategoryRepository categoryRepository;
    private final PostalAddressRepository postalAddressRepository;
    private final AddressBookEntryRepository addressBookEntryRepository;
    private final AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookService(CategoryRepository categoryRepository, PostalAddressRepository postalAddressRepository, AddressBookEntryRepository addressBookEntryRepository, AddressBookRepository addressBookRepository) {
        this.categoryRepository = categoryRepository;
        this.postalAddressRepository = postalAddressRepository;
        this.addressBookEntryRepository = addressBookEntryRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @Transactional
    public Long createAddressBookEntry(User user, AddressBookEntry entry) throws MultipleAddressBooksException {
        List<AddressBook> addressBooks = addressBookRepository.findByUser(user.getId());
        AddressBook addressBook = getAddressBook(user, addressBooks);
        saveCategoriesIfPresent(entry);
        savePostAddressIfPresent(entry);
        entry = addressBookEntryRepository.save(entry);
        updateAddressBookWithEntries(entry, addressBook);
        return entry.getId();
    }

    private void updateAddressBookWithEntries(AddressBookEntry entry, AddressBook addressBook) {
        List<AddressBookEntry> entries = new ArrayList<>();
        entries.add(entry);
        addressBook.setEntries(entries);
        addressBookRepository.save(addressBook);
    }

    private void savePostAddressIfPresent(AddressBookEntry entry) {
        if (entry.getPostalAddress().size() > 0) {
            postalAddressRepository.saveAll(entry.getPostalAddress());
        }
    }

    private void saveCategoriesIfPresent(AddressBookEntry entry) {
        if (entry.getCategories().size() > 0) {
            categoryRepository.saveAll(entry.getCategories());
        }
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
