package de.javengers.addressbook.controller;

import de.javengers.addressbook.entity.Contact;
import de.javengers.addressbook.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressbookController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    LabelRepository labelRepository;

    @RequestMapping(
            path = "/contacts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Contact> getAllContacts(){

        List<Contact> allContacts = contactRepository.findAll();

        return allContacts;
    }

    @PostMapping("contact")
    public Contact saveContact(@RequestBody Contact contact){
        try{
            return contactRepository.save(contact);
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @PostMapping("contacts")
    public List<Contact> createContacts(@RequestBody List<Contact> contacts) {
        try{
            return contactRepository.saveAll(contacts);
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }


}
