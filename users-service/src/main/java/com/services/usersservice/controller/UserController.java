package com.services.usersservice.controller;

import com.services.usersservice.model.User;
import com.services.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> result = userService.getAllUsers();
        if (CollectionUtils.isEmpty(result)) {
            return ResponseEntity.notFound().build();
        }
        result.forEach(e -> {
            e.add(linkTo(methodOn(UserController.class).getUserById(e.getUserId())).withRel("user-by-id"));
            e.add(linkTo(methodOn(UserController.class).getUserByEmail(e.getEmail())).withRel("user-by-email"));
        });
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable int id) {
        User result = userService.getUserById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        result.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"));
        result.add(linkTo(methodOn(UserController.class).getUserByEmail(result.getEmail())).withRel("user-by-email"));
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User result = userService.getUserByEmail(email);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        result.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"));
        result.add(linkTo(methodOn(UserController.class).getUserById(result.getUserId())).withRel("user-by-id"));
        return ResponseEntity.ok(result);
    }
}
