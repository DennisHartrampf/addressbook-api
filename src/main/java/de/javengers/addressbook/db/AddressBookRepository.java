package de.javengers.addressbook.db;

import de.javengers.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

    @Query("SELECT ab FROM AddressBook ab WHERE ab.userId like %?1")
    List<AddressBook> findByUser(Long userId);
}
