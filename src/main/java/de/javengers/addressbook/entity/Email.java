package de.javengers.addressbook.entity;

import de.javengers.addressbook.exception.InvalidEmailException;

import javax.persistence.*;

@Entity
@Table
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email = "";

    public Email(String email){
        if(!email.contains("@")){
            throw  new InvalidEmailException();
        }
        this.email = email;
    }

    public Email() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
