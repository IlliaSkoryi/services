package com.services.usersservice.controller.impl;

import com.services.usersservice.controller.UserController;
import com.services.usersservice.model.User;
import com.services.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User API implementation.
 */
@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private UserService userService;

    /**
     * Constructor.
     *
     * @param userService dependency which provides user service api
     */
    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> result = userService.getAllUsers();
        if (CollectionUtils.isEmpty(result)) {
            return ResponseEntity.notFound().build();
        }
        result.forEach(e -> {
            e.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserControllerImpl.class)
                    .getUserById(e.getUserId())).withRel("user-by-id"));
            e.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserControllerImpl.class)
                    .getUserByEmail(e.getEmail())).withRel("user-by-email"));
        });
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User result = userService.getUserById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        result.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserControllerImpl.class)
                .getAllUsers()).withRel("all-users"));
        result.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserControllerImpl.class)
                .getUserByEmail(result.getEmail())).withRel("user-by-email"));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/email")
    @Override
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User result = userService.getUserByEmail(email);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        result.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserControllerImpl.class)
                .getAllUsers()).withRel("all-users"));
        result.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserControllerImpl.class)
                .getUserById(result.getUserId())).withRel("user-by-id"));
        return ResponseEntity.ok(result);
    }
}
