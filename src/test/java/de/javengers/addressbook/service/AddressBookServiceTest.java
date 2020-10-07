package de.javengers.addressbook.service;

import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

class AddressBookServiceTest {


    @Test
    void testCreateAddressBook(){
        AddressBookService service = new AddressBookService();
        assertThat(service.createAddressBookEntry(new User(), new AddressBookEntry())).isEqualTo(1);

//        verify()
    }

}
