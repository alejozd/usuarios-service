package com.alejo.usuariosservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Spring inyectará automáticamente el CorsConfigurationSource de tu CorsConfig.java
    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            CorsConfigurationSource corsConfigurationSource
    ) throws Exception {
        http
                // 1. Deshabilitar CSRF (necesario para APIs)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Aplicar la configuración de CORS existente
                .cors(cors -> cors.configurationSource(corsConfigurationSource))

                // 3. Configurar la autorización de peticiones
                .authorizeHttpRequests(authorize -> authorize
                        // 🚨 SOLUCIÓN: PERMITIR ACCESO PÚBLICO AL ENDPOINT DE USUARIOS 🚨
                        .requestMatchers("/api/usuarios/**").permitAll()

                        // Permitir todas las peticiones OPTIONS (necesarias para el pre-vuelo de CORS)
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()

                        // Todas las demás rutas deben estar autenticadas (seguridad por defecto)
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}