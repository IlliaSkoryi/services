package com.services.newsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("news controller")
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public ResponseEntity<String> getNewsById(@PathVariable String id) {
        return ResponseEntity.ok("testNews with id = " + id + " in " + environment.getProperty("test") + " mode.");
    }
}
