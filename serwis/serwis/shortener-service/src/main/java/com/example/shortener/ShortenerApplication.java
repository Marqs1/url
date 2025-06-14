package com.example.shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.example.shortener",
        "com.example.common"  // <- dodane, aby Spring widział repozytorium
})
@EnableCassandraRepositories(basePackages = "com.example.common")
public class ShortenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortenerApplication.class, args);
    }
}
