package com.temalabor.temalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TemalabApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemalabApplication.class, args);
    }

}
