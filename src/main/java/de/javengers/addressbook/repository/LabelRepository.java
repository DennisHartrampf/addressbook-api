package de.javengers.addressbook.repository;

import de.javengers.addressbook.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Integer> {
}
