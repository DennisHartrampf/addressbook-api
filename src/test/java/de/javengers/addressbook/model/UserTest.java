package de.javengers.addressbook.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void testGetterSetter(){
        User user = new User();
        user.setId(1L);
        Long id = user.getId();
        assertThat(id).isEqualTo(1);
    }
}
