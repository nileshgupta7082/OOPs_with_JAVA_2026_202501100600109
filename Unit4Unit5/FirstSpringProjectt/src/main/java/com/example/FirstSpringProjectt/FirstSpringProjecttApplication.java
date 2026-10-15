package com.example.FirstSpringProjectt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSpringProjecttApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringProjecttApplication.class, args);
        System.out.println("Hello World from main!");
    }

    // CommandLineRunner executes automatically right after the Spring Application Context is fully loaded
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello World from Spring Boot CommandLineRunner!");
        };
    }
}