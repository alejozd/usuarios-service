package com.alejo.usuariosservice.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Deshabilitar CSRF
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Aplicar la configuración de CORS con el Bean que creamos abajo
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // 3. Configurar la autorización (PERMITE EL ACCESO PÚBLICO)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/usuarios/**").permitAll() // ⬅️ SOLUCIÓN AL 403
                        .requestMatchers(HttpMethod.OPTIONS).permitAll() // Permitir Pre-vuelo de CORS
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    // 🚨 CREA EL BEAN DE CORS QUE SPRING SECURITY NECESITA 🚨
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // **TU CONFIGURACIÓN DE ORIGENES**
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "https://app.zdevs.uk"));

        // **TU CONFIGURACIÓN DE MÉTODOS Y HEADERS**
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowCredentials(true); // Necesario si usas cookies o Auth (aunque uses JWT, es buena práctica)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration); // Aplica la configuración a todas las rutas /api/
        return source;
    }
}