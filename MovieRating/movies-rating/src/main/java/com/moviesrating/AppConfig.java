package com.moviesrating;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ir")
@EntityScan("ir.model")
public class AppConfig {

}
