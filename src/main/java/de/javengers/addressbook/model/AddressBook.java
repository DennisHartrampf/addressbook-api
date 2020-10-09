package de.javengers.addressbook.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<AddressBookEntry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AddressBookEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<AddressBookEntry> entries) {
        this.entries = entries;
    }
}
