package com.services.usersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Users service application starter class.
 */
@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
public class UsersServiceApplication {

    /**
     * Entry point.
     *
     * @param args prams arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(UsersServiceApplication.class, args);
    }
}