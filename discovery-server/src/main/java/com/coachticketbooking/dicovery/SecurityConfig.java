package com.coachticketbooking.dicovery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/eureka/**")) // vẫn tắt CSRF để client POST được
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/**").permitAll()  // tùy chọn, nếu muốn mở health check
                        .anyRequest().authenticated()                // tất cả request khác phải login
                )
                .httpBasic(httpBasic -> {}); // dùng HTTP Basic Auth

        return http.build();
    }
}