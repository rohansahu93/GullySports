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
 */
@Service
public class UserService implements GenericService<User, String> {

    /**
     * Repository instance for User.
     */
    @Autowired
    private UserRepository userRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * Function to get all the users from database.
     * @return list of users
     */
    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * Function to get a single user.
     * @param userID which needs to be updated
     * @return get user
     */
    @Override
    public User getById(String userID) {

        if(userRepository.findById(userID) == null){
            LOGGER.error(String.format("User with ID:%s is not present", userID));
            throw new IllegalArgumentException(String.format("User with ID:%s is not present", userID));
        }

        return userRepository.findById(userID);
    }

    /**
     * Function to add a user.
     * @param user user object which needs to be added
     * @return added user
     */
    @Override
    public User add(User user) {

        if(userRepository.findByPhoneNumber(user.getPhoneNumber()) != null) {
            LOGGER.error(String.format("User with phone number : %s is already present", user.getPhoneNumber()));
            throw new IllegalArgumentException(String.format("User with phone number : %s is already present", user.getPhoneNumber()));
        }

        return userRepository.save(user);
    }

    /**
     * Function to update a user.
     * @param user user object which needs to be updated
     * @return update user
     */
	@Override
	public User update(User user) {

		if (user.getId() == null) {
			throw new IllegalArgumentException("User ID cannot be null");
		}

		User existingUser = userRepository.findById(user.getId());

		if (existingUser == null) {
			LOGGER.error(String.format("User with ID:%s is not present", user.getId()));
			throw new IllegalArgumentException(String.format("User with ID:%s is not present", user.getId()));
		}

		if (!existingUser.getPhoneNumber().equals(user.getPhoneNumber())) {
			LOGGER.error(String.format("User with ID:%s cannot change Phone Number", user.getId()));
			throw new IllegalArgumentException(
					String.format("User with ID:%s cannot change Phone Number", user.getId()));
		}

		if (user.getEmail() != null) {
			if (userRepository.findByEmail(user.getEmail()) != null) {
				LOGGER.error(String.format("User ID: %s cannot use Email : %s is already present in other account",
						user.getId(), user.getEmail()));
				throw new IllegalArgumentException(
						String.format("User ID: %s cannot use Email : %s is already present in other account",
								user.getId(), user.getEmail()));
			}
		}

		user.setCreatedDate(existingUser.getCreatedDate());

		return userRepository.save(user);
	}

    /**
     * Function to delete a user.
     * @param userID which needs to be deleted
     * @return update user
     */
    @Override
    public void delete(String userID){

        // TODO :  Delete entities which are linked with this user

        if(userRepository.findById(userID) == null){
            LOGGER.error(String.format("User with ID:%s is not present", userID));
            throw new IllegalArgumentException(String.format("User with ID:%s is not present", userID));
        }
        userRepository.delete(userID);
        LOGGER.info(String.format("USER: User id:%s deleted", userID));
    }
}
