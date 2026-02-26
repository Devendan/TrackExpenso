package com.dev.ExpenseTracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("http://localhost:5173" ,
                "https://expensefrontend-production.up.railway.app"));

        config.setAllowedMethods(List.of("GET" , "POST" ,"PUT","DELETE"));

        config.setAllowedHeaders(List.of("*"));

        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();

        src.registerCorsConfiguration("/**" ,config);

        return new CorsFilter(src);
    }


}
