package de.javengers.addressbook.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AddressBookEntryTest {
    
    @Test
    void testGetterAndSetter() {

        AddressBookEntry addressBookEntry = new AddressBookEntry();

        addressBookEntry.setId(42L);
        Long id = addressBookEntry.getId();
        assertThat(id).isEqualTo(42L);

        String inputSalutation = "Frau";
        addressBookEntry.setSalutation(inputSalutation);
        String salutation = addressBookEntry.getSalutation();
        assertThat(salutation).isEqualTo(inputSalutation);


        addressBookEntry.setFirstName("myFirstName");

        assertThat(addressBookEntry.getFirstName()).isEqualTo("myFirstName");


        addressBookEntry.setLastName("myLastName");

        assertThat(addressBookEntry.getLastName()).isEqualTo("myLastName");



        addressBookEntry.setCompany("myCompany");
        assertThat(addressBookEntry.getCompany()).isEqualTo("myCompany");



        addressBookEntry.setPhoneNumbers(List.of("myPhoneNumber1","myPhoneNumber2"));
        assertThat(addressBookEntry.getPhoneNumbers()).isEqualTo(List.of("myPhoneNumber1","myPhoneNumber2"));




        addressBookEntry.setEmailAddresses(List.of("myEmailAddress1","myEmailAddress2"));
        assertThat(addressBookEntry.getEmailAddresses()).isEqualTo(List.of("myEmailAddress1","myEmailAddress2"));



        PostalAddress postalAddress1 = new PostalAddress(1L,
                                                        "Street",
                                                        "HouseNumber",
                                                        "ZipCode",
                                                        "City",
                                                        "Country");
        PostalAddress postalAddress2 = new PostalAddress(2L,
                                                        "Street",
                                                        "HouseNumber",
                                                        "ZipCode",
                                                        "City",
                                                        "Country");

        addressBookEntry.setPostalAddress(List.of(postalAddress1,postalAddress2));
        assertThat(addressBookEntry.getPostalAddress()).isEqualTo(List.of(postalAddress1,postalAddress2));


        Category category1 = new Category(1L, "Category Name");
        Category category2 = new Category(2L, "Category Name");

        addressBookEntry.setCategories(List.of(category1,category2));
        assertThat(addressBookEntry.getCategories()).isEqualTo(List.of(category1,category2));


        assertThat(addressBookEntry.isVip()).isFalse();
        addressBookEntry.setVip(true);
        assertThat(addressBookEntry.isVip()).isTrue();



        addressBookEntry.setDescription("myDescription");
        assertThat(addressBookEntry.getDescription()).isEqualTo("myDescription");


        addressBookEntry.setPhoto("myPhoto");
        assertThat(addressBookEntry.getPhoto()).isEqualTo("myPhoto");
    }

}
