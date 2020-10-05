package de.javengers.addressbook.exception;

public class InvalidPhoneNumberException extends RuntimeException {

    public InvalidPhoneNumberException(){
        super("Not a valid phone number");
    }
}
