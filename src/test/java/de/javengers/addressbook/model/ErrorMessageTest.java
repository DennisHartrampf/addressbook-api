package de.javengers.addressbook.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {

    private static final String MESSAGE = "Message";

    @Test
    void testGetterSetter() {
        ErrorMessage message = new ErrorMessage();
        message.setMessage(MESSAGE);
        assertThat(message.getMessage()).isEqualTo(MESSAGE);
    }

    @Test
    void testConstructor(){
        ErrorMessage message = new ErrorMessage(MESSAGE);
        assertThat(message.getMessage()).isEqualTo(MESSAGE);
    }
}
