package com.gullysports.services;

import com.gullysports.db.UserRepository;
import com.gullysports.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Users class which is responsible for managing all the users we are supporting
 * related to project GullySports.
 *
 * @author rohan.sahu
 * TODO :  Refactor service - create base service
 */
@Service
public class UserService {

    /**
     * Repository instance for Asset.
     */
    @Autowired
    private UserRepository userRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * Function to get all the users from database.
     * @return list of users
     */
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * Function to get a single user.
     * @param userID which needs to be updated
     * @return get user
     */
    public User getUser(String userID) {

        if(userRepository.findById(userID) == null){
            throw new IllegalArgumentException(String.format("User with ID:%s is not present", userID));
        }

        return userRepository.findById(userID);
    }

    /**
     * Function to add a user.
     * @param user user object which needs to be added
     * @return added user
     */
    public User addUser(User user) {

        if(!(userRepository.findByPhoneNumber(user.getPhoneNumber()).isEmpty())){
            throw new IllegalArgumentException(String.format("User with phone number : %s is already present", user.getPhoneNumber() ));
        }

        return userRepository.save(user);
    }

    /**
     * Function to update a user.
     * @param user user object which needs to be updated
     * @return update user
     */
    public User updateUser(User user){

        if(user.getId() == null){
            throw new IllegalArgumentException("User ID cannot be null");
        }

        if(userRepository.findById(user.getId()) == null){
            LOGGER.error(String.format("User with ID:%s is not present", user.getId()));
            throw new IllegalArgumentException(String.format("User with ID:%s is not present", user.getId()));
        }

        if(userRepository.findById(user.getId()).getPhoneNumber() != user.getPhoneNumber()){
            LOGGER.error(String.format("User with ID:%s cannot change Phone Number", user.getId()));
            throw new IllegalArgumentException(String.format("User with ID:%s cannot change Phone Number", user.getId()));
        }

        return userRepository.save(user);
    }

    /**
     * Function to delete a user.
     * @param userID which needs to be deleted
     * @return update user
     */
    public void deleteUser(String userID){

//        TODO :  Delete entities which are linked with this user

        if(userRepository.findById(userID) == null){
            LOGGER.error(String.format("User with ID:%s is not present", userID) );
            throw new IllegalArgumentException(String.format("User with ID:%s is not present", userID));
        }
        userRepository.delete(userID);
        LOGGER.info(String.format("USER: User id:%s deleted", userID));
    }
}
