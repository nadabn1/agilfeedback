package agilefeedback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        // En DEV, tout est ouvert
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();

        // Si tu préfères restreindre strictement :
        // cfg.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        // Pour être plus souple (notamment si tu changes de port) :
        cfg.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200", "http://127.0.0.1:*", "http://localhost:*"));

        cfg.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD"));
        cfg.setAllowedHeaders(Arrays.asList("*"));
        cfg.setExposedHeaders(Arrays.asList("Authorization", "Location", "Content-Disposition"));
        cfg.setAllowCredentials(true);
        cfg.setMaxAge(3600L); // cache du preflight 1h

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
