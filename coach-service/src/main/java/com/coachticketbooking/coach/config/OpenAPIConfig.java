package com.coachticketbooking.coach.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI()
                .servers(List.of(new Server().url("http://localhost:9000/api/v1/coaches"), new Server().url("http://localhost:" + serverPort)))
                .info(new Info()
                        .title("Coach Service API")
                        .version("1.0.0")
                        .description("Coach Service API for Coach Ticket Booking Application")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .addSecurityItem(new SecurityRequirement().addList("Keycloak"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Keycloak", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new OAuthFlows()
                                        .authorizationCode(new OAuthFlow()
                                                .authorizationUrl("http://localhost:8080/realms/spring-coach-ticket-booking-realm/protocol/openid-connect/auth")
                                                .tokenUrl("http://localhost:8080/realms/spring-coach-ticket-booking-realm/protocol/openid-connect/token")
                                        ))));

        // Clear security requirements for any path that matches /public/** so those operations are shown as public in the OpenAPI UI.
        if (openAPI.getPaths() != null) {
            openAPI.getPaths().forEach((path, pathItem) -> {
                if (path != null && (path.contains("/public/") || path.endsWith("/public"))) {
                    pathItem.readOperations().forEach(op -> op.setSecurity(Collections.emptyList()));
                }
            });
        }

        return openAPI;
    }

}
