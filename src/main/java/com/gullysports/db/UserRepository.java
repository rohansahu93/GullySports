package com.gullysports.db;

import com.gullysports.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * UserRepository interface, declares the methods exposed by the repository.
 * Following default methods are provided by CrudRepository and can be used as
 * is without requiring any implementation. save, findOne, exists, findAll,
 * count, delete and deleteAll. Please refer to the javadocs for more details.
 *
 * @author rohan.sahu
 */
public interface UserRepository extends CrudRepository<User, String> {
    /**
     * Finds a User object that matches the name parameter. Spring
     * automatically formulates appropriate query depending on the name of the
     * method. findByXXX() method would look for a match for XXX property and
     * return the object instance.
     *
     * @param phoneNumber email of the User
     * @return User Object matching the name parameter
     */

    List<User> findByPhoneNumber(int phoneNumber);

    User findById(String id);
}
