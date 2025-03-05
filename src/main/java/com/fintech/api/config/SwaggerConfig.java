package com.fintech.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
        @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Fintech - Sebastian Vivas")
                .version("1.0.0")
                .description("Documentación de la API Fintech. Proyecto realizado a través de Java Springboot.")
                .contact(new Contact()
                        .name("Sebastian Vivas")
                        .email("sebastian14vivas@hotmail.com")
                        .url("https://www.linkedin.com/in/sluisvivas/")
            )
                );
    }
}