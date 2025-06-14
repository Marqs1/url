package com.example.cleaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.cleaner", "com.example.common"})
@EnableCassandraRepositories(basePackages = "com.example.common")
public class CleanerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleanerApplication.class, args);
    }
}
