package de.javengers.addressbook.service;

import de.javengers.addressbook.db.AddressBookEntryRepository;
import de.javengers.addressbook.db.AddressBookRepository;
import de.javengers.addressbook.db.CategoryRepository;
import de.javengers.addressbook.db.PostalAddressRepository;
import de.javengers.addressbook.model.AddressBook;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AddressBookServiceTest {

    private CategoryRepository categoryRepository;
    private PostalAddressRepository postalAddressRepository;
    private AddressBookEntryRepository addressBookEntryRepository;
    private AddressBookRepository addressBookRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        postalAddressRepository = mock(PostalAddressRepository.class);
        addressBookEntryRepository = mock(AddressBookEntryRepository.class);
        addressBookRepository = mock(AddressBookRepository.class);
    }

    @Test
    void testCreateAddressBook() {
        AddressBookService service = new AddressBookService(categoryRepository, postalAddressRepository, addressBookEntryRepository);

        AddressBookEntry entry = new AddressBookEntry();
        User user = new User();
        user.setId(123L);

        AddressBook newAddressBook = new AddressBook();
        newAddressBook.setUser(user);
        newAddressBook.setId(12L);

        when(addressBookRepository.findByUser(user.getId())).thenReturn(List.of());
        assertThat(service.createAddressBookEntry(user, entry)).isEqualTo(1);
        verify(addressBookRepository).findByUser(user.getId());
        verify(addressBookRepository.save(newAddressBook));
        verify(categoryRepository).saveAll(entry.getCategories());
        verify(postalAddressRepository).saveAll(entry.getPostalAddress());
        verify(addressBookEntryRepository).save(entry);

    }

}
