package com.project.hospital_management_system;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // allow all endpoints
            .allowedOrigins("http://localhost:3000") // allow React app
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // include OPTIONS for preflight
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
