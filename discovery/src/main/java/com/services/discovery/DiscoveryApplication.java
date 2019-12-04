package com.services.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Discovery application service starter class.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

    /**
     * Entry point.
     *
     * @param args parameters arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}
