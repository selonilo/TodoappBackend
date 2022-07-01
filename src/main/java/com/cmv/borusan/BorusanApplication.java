package com.cmv.borusan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@OpenAPIDefinition
public class BorusanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorusanApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${app.description}") String description,
								 @Value("${app.version}") String version){
		return new OpenAPI()
				.info(new Info()
						.title("COUNTING")
						.version(version)
						.description(description)
						.license(new License().name("CMV COUNTING API License 1.0")));
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");

			}
		};
	}
}
