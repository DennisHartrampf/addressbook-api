package de.javengers.addressbook.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AddressBookTest {

    @Test
    public void testGetterSetter(){
        AddressBook addressBook = new AddressBook();

        addressBook.setId(1L);
        User user = new User();
        addressBook.setUser(user);
        List<AddressBookEntry> addressBookEntries = new ArrayList<>();
        addressBookEntries.add(new AddressBookEntry());
        addressBookEntries.add(new AddressBookEntry());
        addressBook.setEntries(addressBookEntries);

        assertThat(addressBook.getId()).isEqualTo(1);
        assertThat(addressBook.getUser()).isEqualTo(user);
        assertThat(addressBook.getEntries()).isEqualTo(addressBookEntries);
    }

}
