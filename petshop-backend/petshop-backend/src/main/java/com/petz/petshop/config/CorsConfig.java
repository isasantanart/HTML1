package com.petz.petshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
        	@Override
        	public void addCorsMappings(CorsRegistry registry) {
        	    registry.addMapping("/**")
        	            .allowedOriginPatterns("*") // Troque Origins por OriginPatterns
        	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        	            .allowedHeaders("*")
        	            .allowCredentials(false);
        	}
        }; // Fechamento da classe anônima e do return
    }
} // Fechamento da classe principal