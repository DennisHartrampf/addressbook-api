package de.javengers.addressbook.repository;

import de.javengers.addressbook.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
