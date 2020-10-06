package de.javengers.addressbook.db;

import de.javengers.addressbook.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User get(String userId){
        return new User();
    }
}
