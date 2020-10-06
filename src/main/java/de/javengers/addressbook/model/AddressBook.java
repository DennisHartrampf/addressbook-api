package de.javengers.addressbook.model;

import java.util.List;

public class AddressBook {

    private Long id;
    private User user;
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
