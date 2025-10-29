package com.coachticketbooking.apigateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gateway Service")
                        .description("API Gateway Service")
                        .version("1.0.0"))
                .addSecurityItem(new SecurityRequirement().addList("Keycloak"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Keycloak", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new OAuthFlows()
                                        .authorizationCode(new OAuthFlow()
                                                .authorizationUrl("http://localhost:8080/realms/spring-coach-ticket-booking-realm/protocol/openid-connect/auth")
                                                .tokenUrl("http://localhost:8080/realms/spring-coach-ticket-booking-realm/protocol/openid-connect/token")
                                        ))));
    }
}
