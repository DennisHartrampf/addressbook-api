package de.javengers.addressbook.entity;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String streetName;
    private int houseNumber;
    private String city;
    private int zipCode;
    private String country;

    public Address() {
    }

    public Address(String streetName, int houseNumber, String city, int zipCode, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
