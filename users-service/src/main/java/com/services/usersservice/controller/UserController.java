package com.services.usersservice.controller;

import com.services.usersservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * API interface for users operations.
 */
public interface UserController {

    /**
     * Retrieves list of all existing {@link User}.
     *
     * @return {@link ResponseEntity} list of users
     */
    ResponseEntity<List<User>> getAllUsers();

    /**
     * Retrieves {@link User} by id.
     *
     * @param id user id in INT range
     * @return {@link ResponseEntity} of {@link User} type
     */
    ResponseEntity<User> getUserById(@PathVariable int id);

    /**
     * Retrieves {@link User} by user email.
     *
     * @param email user email
     * @return {@link ResponseEntity} of {@link User} type
     */
    ResponseEntity<User> getUserByEmail(@RequestParam String email);
}
