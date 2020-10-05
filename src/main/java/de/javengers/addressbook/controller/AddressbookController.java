package de.javengers.addressbook.controller;

import de.javengers.addressbook.entity.Person;
import de.javengers.addressbook.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressbookController {


    @Autowired
    PersonRepository personRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    LabelRepository labelRepository;

    @RequestMapping(
            path = "/persons",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getAllPerson(){

        List<Person> allPerson = personRepository.findAll();

        return allPerson;
    }

    @PostMapping("person")
    public Integer savePerson(@RequestBody Person person){
        try{
            Person p = personRepository.save(person);
            return p.getId();
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @PostMapping("persons")
    public List<Person> createPersons(@RequestBody List<Person> persons) {
        try{
            return personRepository.saveAll(persons);
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }


}
