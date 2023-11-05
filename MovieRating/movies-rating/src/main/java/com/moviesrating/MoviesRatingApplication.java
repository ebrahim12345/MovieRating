package com.moviesrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class MoviesRatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesRatingApplication.class, args);
    }

}
