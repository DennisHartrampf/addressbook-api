package de.javengers.addressbook.repository;

import de.javengers.addressbook.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
