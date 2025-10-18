package com.project.hospital_management_system.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

    @Bean  // it is a method level annotation which is responsible to create the object at method level
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                		.title("Hospital Management System")
                		.description("Hospital Management System is a project designed for both online and offline purposes. "
                		        + "This system allows users to manage patient records, schedule appointments, and handle doctor and staff information. "
                		        + "It streamlines operations like billing, admission, discharge, and provides efficient access to medical data, "
                		        + "improving the coordination and management of healthcare services.")

                        .version("1.1")
                        .contact(new Contact()
                                .name("Qspiders Team")
                                .email("qspiders@gmail.com"))
                        .license(new License().name("License").url("#")));
    }

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public").
				packagesToScan("com.project.hospital_management_system").build();
	}
}
