package com.services.newsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * News service starter class.
 */
@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
public class NewsServiceApplication {

    /**
     * Application entry point.
     *
     * @param args parameters arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(NewsServiceApplication.class, args);
    }

}
