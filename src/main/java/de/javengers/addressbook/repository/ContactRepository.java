package de.javengers.addressbook.repository;

import de.javengers.addressbook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
