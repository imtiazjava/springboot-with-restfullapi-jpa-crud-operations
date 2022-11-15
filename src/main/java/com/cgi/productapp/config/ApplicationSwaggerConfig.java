package com.cgi.productapp.config;

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
public class ApplicationSwaggerConfig {

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.cgi.productapp"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		    
		return new ApiInfo("SPRINBOOT WITH SWAGGER DOCUMENATION",
				"THIS IS MY FIRST SWAGGER DOCUMENATION",
				"Swagger 1.0v",
				"https://www.apache.com", new Contact("IMTIAZ", "http://localhost:8080/api/product", "IMTIAZ@GMAIL.COM"),
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
}
