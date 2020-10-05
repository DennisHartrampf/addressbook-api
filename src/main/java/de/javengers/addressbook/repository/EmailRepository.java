package de.javengers.addressbook.repository;

import de.javengers.addressbook.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}
