package de.javengers.addressbook.model;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.*;
import java.util.List;


@EnableSwagger2
@Entity
public class AddressBookEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String salutation;
    private String firstName;
    private String lastName;
    private String company;
    @ElementCollection
    private List<String> phoneNumbers;
    @ElementCollection
    private List<String> emailAddresses;
    @OneToMany
    private List<PostalAddress> postalAddress;
    @OneToMany
    private List<Category> categories;

    private boolean vip;
    private String description;
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSalutation(String salutation) {

        this.salutation = salutation;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setPostalAddress(List<PostalAddress> postalAddress) {
        this.postalAddress = postalAddress;
    }

    public List<PostalAddress> getPostalAddress() {
        return postalAddress;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
