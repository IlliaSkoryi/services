package com.services.usersservice.service;

import com.services.usersservice.model.User;

import java.util.List;

/**
 * User service API.
 */
public interface UserService {

    /**
     * Provides ability to retrieve list of all users from persistence layer.
     *
     * @return list of {@link User} entities
     */
    List<User> getAllUsers();

    /**
     * Provides ability to retrieve {@link User} from persistence layer by id.
     *
     * @param id user id
     * @return {@link User} entity
     */
    User getUserById(int id);

    /**
     * Provides ability to retrieve {@link User} from persistence layer by email.
     *
     * @param email user email
     * @return {@link User} entity
     */
    User getUserByEmail(String email);
}
