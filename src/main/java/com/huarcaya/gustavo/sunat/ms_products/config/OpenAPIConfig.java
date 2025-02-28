package com.huarcaya.gustavo.sunat.ms_products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        // https://www.bezkoder.com/spring-boot-swagger-3/
        Info info = new Info()
                .title("Products API")
                .version("0.1.0")
                .description("Product Microservice");

        return new OpenAPI().info(info);
    }
}
