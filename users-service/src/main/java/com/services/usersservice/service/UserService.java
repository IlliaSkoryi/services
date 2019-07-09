package com.services.usersservice.service;

import com.services.usersservice.model.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}
