package de.javengers.addressbook.exception;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(){
        super("That's not an email");
    }
}
