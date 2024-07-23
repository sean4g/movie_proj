package com.example.MovieWatcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String exampleBean() {
        System.out.println("Example Bean created");
        return "exampleBean";
    }
}