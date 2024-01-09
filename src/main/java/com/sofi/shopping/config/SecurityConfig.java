package com.sofi.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
            http.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(request->request.requestMatchers(
                            "/api/auth/**").permitAll()
                            .anyRequest().authenticated())
                    .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            return http.build();
/*Falta porque no tengo el UserDetailsImpl ni el DoFIlter para agregar JWT*/





    }
}
