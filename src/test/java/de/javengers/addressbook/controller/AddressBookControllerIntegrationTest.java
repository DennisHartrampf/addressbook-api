package de.javengers.addressbook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.javengers.addressbook.db.UserRepository;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.PostalAddress;
import de.javengers.addressbook.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.emptyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class AddressBookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setId(1L);
        userRepository.save(user);
    }


    @Test
    void testCreateAddressBook_success() throws Exception {
        final User user = new User();
        user.setId(1L);
        mockMvc.perform(post("/api/addressbook/").header("userId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getEntryJsonString()))
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.LOCATION, "/api/addressbook/1"))
                .andExpect(content().string(emptyString()));
    }

    private String getEntryJsonString() throws JsonProcessingException {
        PostalAddress postalAddress1 = new PostalAddress(1L,
                "Street",
                "HouseNumber",
                "ZipCode",
                "City",
                "Country");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        AddressBookEntry addressBookEntry = new AddressBookEntry();
        addressBookEntry.setLastName("Genc");
        addressBookEntry.setSalutation("Mr");
        addressBookEntry.setFirstName("Birkan");
        addressBookEntry.setPostalAddress(List.of(postalAddress1));
        return objectMapper.writeValueAsString(addressBookEntry);
    }


}
