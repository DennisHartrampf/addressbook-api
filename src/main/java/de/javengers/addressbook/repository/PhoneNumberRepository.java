package de.javengers.addressbook.repository;

import de.javengers.addressbook.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
}
