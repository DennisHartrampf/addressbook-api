package de.javengers.addressbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.PostalAddress;
import de.javengers.addressbook.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = UserServiceMock.class)
@ComponentScan("de.javengers.addressbook")
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void testCreateAddressBook_MissingUserId() throws Exception {
        mockMvc.perform(
                post("/api/addressbook"))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason(containsString("Missing request header 'userId' for method parameter of type String")));
    }

    @Test
    public void testCreateAddressBook_UserDoesNotExist() throws Exception {
        doThrow(new NoSuchUserException("User with userId=123 is not found.")).when(userService).getUser(anyString());
        mockMvc.perform(
                post("/api/addressbook/").contentType(MediaType.APPLICATION_JSON)
                        .header("userId", "123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("{\"message\":\"User with userId=123 is not found.\"}")));
    }

    @Test
    public void testCreateAddressBook() throws Exception {

        PostalAddress postalAddress1 = new PostalAddress(1L,
                "Street",
                "HouseNumber",
                "ZipCode",
                "City",
                "Country");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        AddressBookEntry addressBookEntry = new AddressBookEntry();
        addressBookEntry.setPostalAddress(List.of(postalAddress1));
        List<AddressBookEntry> addressBookEntries = List.of(addressBookEntry);
        String bookEntries = objectMapper.writeValueAsString(addressBookEntries);

        mockMvc.perform(
                post("/api/addressbook/")
                        .header("userId", "123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookEntries))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("{\"message\":\"User with userId=123 is not found.\"}")));
    }

}

