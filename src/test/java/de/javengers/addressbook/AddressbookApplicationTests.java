package de.javengers.addressbook;

import de.javengers.addressbook.db.AddressBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AddressbookApplicationTests {
	@MockBean
	private AddressBookRepository addressBookRepository;

	@Test
	void contextLoads() {
	}

}
