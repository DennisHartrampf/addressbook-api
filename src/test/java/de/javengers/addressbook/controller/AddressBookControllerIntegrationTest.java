package de.javengers.addressbook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.javengers.addressbook.db.AddressBookRepository;
import de.javengers.addressbook.exception.MultipleAddressBooksException;
import de.javengers.addressbook.exception.NoSuchUserException;
import de.javengers.addressbook.model.AddressBookEntry;
import de.javengers.addressbook.model.PostalAddress;
import de.javengers.addressbook.model.User;
import de.javengers.addressbook.service.AddressBookService;
import de.javengers.addressbook.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class AddressBookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private AddressBookService addressBookService;

    @MockBean
    private AddressBookRepository addressBookRepository;

    @Test
    void testCreateAddressBook_MissingUserId() throws Exception {
        mockMvc.perform(post("/api/addressbook").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andExpect(status().reason(containsString(
                   "Missing request header 'userId' for method parameter of type Long")));
    }

    @Test
    void testCreateAddressBook_UserDoesNotExist() throws Exception {
        doThrow(new NoSuchUserException("User with userId=123 is not found.")).when(userService)
                                                                              .getUser(anyLong());
        mockMvc.perform(post("/api/addressbook/").contentType(MediaType.APPLICATION_JSON)
                                                 .header("userId", "123")
                                                 .content(getEntryJsonString()))
               .andExpect(status().isBadRequest())
               .andExpect(content().string(containsString(
                   "{\"message\":\"User with userId=123 is not found.\"}")));
    }

    @Test
    void testCreateAddressBook_success() throws Exception {
        final User user = new User();
        user.setId(1L);
        when(userService.getUser(anyLong())).thenReturn(user);
        when(addressBookService.createAddressBookEntry(any(), any())).thenReturn(2L);
        mockMvc.perform(post("/api/addressbook/").header("userId", "1")
                                                 .contentType(MediaType.APPLICATION_JSON)
                                                 .content(getEntryJsonString()))
               .andExpect(status().isCreated())
               .andExpect(header().string(HttpHeaders.LOCATION, "/api/addressbook/2"))
               .andExpect(content().string(emptyString()));
    }

    @Test
    void testCreateAddressBook_MultipleAddressBooks() throws Exception {
        doThrow(new MultipleAddressBooksException("There are already 2 AddressBooks for the user 123 exist.")).when(addressBookService)
                .createAddressBookEntry(any(), any());
        mockMvc.perform(post("/api/addressbook/").contentType(MediaType.APPLICATION_JSON)
                .header("userId", "123")
                .content(getEntryJsonString()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(
                        "{\"message\":\"There are already 2 AddressBooks for the user 123 exist.\"}")));
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
        addressBookEntry.setPostalAddress(List.of(postalAddress1));
        return objectMapper.writeValueAsString(addressBookEntry);
    }

}

