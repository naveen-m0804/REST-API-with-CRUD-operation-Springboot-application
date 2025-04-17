package com.example.hellorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // your React frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // allow necessary methods
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
