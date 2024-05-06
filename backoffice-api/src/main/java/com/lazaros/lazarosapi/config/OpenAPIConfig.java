package com.lazaros.lazarosapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder().group("public-api").pathsToMatch("/**").build();

    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Lazaros API").version("1.0"));
    }

}
