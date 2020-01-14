package com.casatoronto.challenge.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Eduardo Calado", "https://www.linkedin.com/in/eduardocalado/", "ecalado@gmail.com");
		
		ApiInfo apiInfo = new ApiInfo("Challenge at CasaToronto REST API", 
									  "This api was the result of the participation of the challenge offered by Casa toronto",
									  "1.0.0",
									  "Terms of service",
									  contact, 
									  "Apache 2.0", 
									  "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	    
		return apiInfo;
	}
}