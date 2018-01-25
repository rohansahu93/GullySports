package com.gullysports.controllers;

import com.gullysports.models.User;
import com.gullysports.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * This class is responsible for exposing REST APis for users.
 */
@RestController
@RequestMapping("v1/users")
public class UserController {
    /**
     * Spring will initialize UserService object.
     */
    @Autowired
    private UserService userService;

    /**
     * Rest Interface for fetching all the users.
     *
     * @return List of users
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getAllUsers() throws Exception {
        return userService.getAll();
    }

    /**
     * Rest interface for adding a user.
     *
     * @param user
     * @return added user details
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public User addUser(@RequestBody @Valid User user) throws Exception{

        return userService.add(user);
    }

    /**
     * Rest Interface for fetching single user.
     *
     * @return Single user
     * @throws Exception
     */
    @RequestMapping(value = "{userID}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable("userID") String userID) throws Exception {
        return userService.getById(userID);
    }

    /**
     * Rest Interface for updating user.
     *
     * @return updated user
     * @throws Exception
     */

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public User updateUser(@RequestBody @Valid User user) throws Exception {
        return userService.update(user);
    }

    /**
     * Rest Interface for deleting user.
     *
     * @return deleting user
     * @throws Exception
     */

    @RequestMapping(value = "{userID}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void deleteUser(@PathVariable("userID") String userID) throws Exception {
        userService.delete(userID);
    }
}
