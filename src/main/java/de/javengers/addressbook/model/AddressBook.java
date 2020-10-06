package de.javengers.addressbook.model;

import java.util.List;

public class AddressBook {
    private Long id;
    private Long userId;
    private List<AddressBookEntry> entries;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public List<AddressBookEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<AddressBookEntry> entries) {
        this.entries = entries;
    }
}
