//package com.project.hospital_management_system.config;
//
//public class SecurityConfig {
//
//}
package com.project.hospital_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("http://localhost:5179")
	                    .allowedMethods("GET", "POST", "PUT", "DELETE")
	                    .allowedHeaders("*");
	        }
	    };
	}

	
	
   }

