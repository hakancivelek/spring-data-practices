package com.hakancivelek.spring.data.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringDataPracticesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataPracticesApplication.class, args);
    }

}
