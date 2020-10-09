package de.javengers.addressbook.db;

import de.javengers.addressbook.model.PostalAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalAddressRepository extends JpaRepository<PostalAddress, Long> {
}
