package de.javengers.addressbook.entity;

import de.javengers.addressbook.exception.InvalidPhoneNumberException;

import javax.persistence.*;

@Entity
@Table
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private long number;

    public PhoneNumber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public PhoneNumber(String number){
        try{
            String telNum = number.replace("(", "");
            telNum = telNum.replace(")", "");
            telNum = telNum.replace("-", "");
            telNum = telNum.replace("+", "00");
            telNum = telNum.replace("//s", "");

            this.number = Long.parseLong(telNum);
        } catch(NumberFormatException e){
            throw new InvalidPhoneNumberException();
        }

    }
}
