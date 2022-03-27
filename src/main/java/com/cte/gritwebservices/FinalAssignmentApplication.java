package com.cte.gritwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
		title = "API documentation for final assignement in Webservices", 
		version = "0.0.1", 
		description = 
			"This is an API test and description for following functionalities" +
			"<br>" + 
			"The calculator; able to process 3 arithmetics:" +
			"<ol>"
			+ "<li>Substraction</li>"
			+ "<li>Multiplication</li>"
			+ "<li>Addition</li>"
			+ "</ol>" + 
			"<br>" +
			"There is also support for selecting a spcific arithmetic in the Multiple Arithmetics endpoint."		
		))

@SpringBootApplication
public class FinalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAssignmentApplication.class, args);
	}

}
