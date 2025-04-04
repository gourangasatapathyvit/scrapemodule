package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ModuleConfigurationApp {

    private final List<String> allowedOrigins;

    public ModuleConfigurationApp(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    @Bean
    public CorsFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

//        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:8080","https://theultimatescrapper.vercel.app/","http://theultimatescrapper.vercel.app/"));
        corsConfig.setAllowedOrigins(allowedOrigins);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        corsConfig.setMaxAge(3600L);
        corsConfig.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsFilter(source);
    }

    public static void main(String[] args) {
        System.out.println("CORS module loaded");
    }
}
