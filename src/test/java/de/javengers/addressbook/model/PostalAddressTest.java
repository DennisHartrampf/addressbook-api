package de.javengers.addressbook.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostalAddressTest {

    @Test
    void testGettersAndSetters() {
        PostalAddress postalAddress = new PostalAddress();

        postalAddress.setId(1L);
        postalAddress.setStreet("Street");
        postalAddress.setHouseNumber("HouseNumber");
        postalAddress.setZipCode("ZipCode");
        postalAddress.setCity("City");
        postalAddress.setCountry("Country");

        assertThat(postalAddress.getId()).isEqualTo(1);
        assertThat(postalAddress.getStreet()).isEqualTo("Street");
        assertThat(postalAddress.getHouseNumber()).isEqualTo("HouseNumber");
        assertThat(postalAddress.getZipCode()).isEqualTo("ZipCode");
        assertThat(postalAddress.getCity()).isEqualTo("City");
        assertThat(postalAddress.getCountry()).isEqualTo("Country");
    }



    @Test
    void testConstructor() {
        PostalAddress postalAddress = new PostalAddress(1L,
                                                        "Street",
                                                        "HouseNumber",
                                                        "ZipCode",
                                                        "City",
                                                        "Country");


        assertThat(postalAddress.getId()).isEqualTo(1);
        assertThat(postalAddress.getStreet()).isEqualTo("Street");
        assertThat(postalAddress.getHouseNumber()).isEqualTo("HouseNumber");
        assertThat(postalAddress.getZipCode()).isEqualTo("ZipCode");
        assertThat(postalAddress.getCity()).isEqualTo("City");
        assertThat(postalAddress.getCountry()).isEqualTo("Country");
    }
    
}
