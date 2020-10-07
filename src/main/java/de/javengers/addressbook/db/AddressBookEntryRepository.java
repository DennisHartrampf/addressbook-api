package de.javengers.addressbook.db;

import de.javengers.addressbook.model.AddressBookEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookEntryRepository extends JpaRepository<AddressBookEntry, Long> {
}
