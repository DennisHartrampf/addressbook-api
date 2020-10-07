package de.javengers.addressbook.service;

import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AddressBookServiceTest {

    @Test
    public void testCreateAddressBook(){
        AddressBookService service = new AddressBookService();
        assertThat(service.createAddressBookEntry(new User(), new AddressBookEntry())).isEqualTo(1);
    }

}
