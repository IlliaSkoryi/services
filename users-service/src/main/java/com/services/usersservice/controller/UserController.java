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

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public ResponseEntity getAllUsers() {
        List<User> result = userService.getAllUsers();
        if (CollectionUtils.isEmpty(result)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable int id) {
        User result = userService.getUserById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/email")
    public ResponseEntity getUserByEmail(@RequestParam String email) {
        User result = userService.getUserByEmail(email);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
