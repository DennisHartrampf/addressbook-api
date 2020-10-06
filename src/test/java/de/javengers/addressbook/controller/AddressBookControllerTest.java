package de.javengers.addressbook.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAddressBook_MissingUserId() throws Exception {
        mockMvc.perform(
                post("/api/addressbook"))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason(containsString("Missing request header 'userId' for method parameter of type String")));
    }

    @Test
    public void testCreateAddressBook_UserDoesNotExist() throws Exception {
        mockMvc.perform(
                post("/api/addressbook/")
                        .header("userId", "123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("{\"message\":\"User with userId=123 is not found.\"}")));
    }

}
