package de.javengers.addressbook.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    // TODO nicht in der Aufgabe spezifiziert
    private Date dob;

    private String company;

    private String vipStatus;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Label> labels;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> emails;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    public Contact() {}

    public Contact(@NotNull String firstName, @NotNull String lastName, Date dob, String company, String vipStatus, String description, List<Label> labels, List<Email> emails, List<Address> addresses, List<PhoneNumber> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.company = company;
        this.vipStatus = vipStatus;
        this.description = description;
        this.labels = labels;
        this.emails = emails;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
