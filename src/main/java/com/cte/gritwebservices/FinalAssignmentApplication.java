package com.cte.gritwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
		title = "API documentation for final assignement in Webservices", 
		version = "0.0.1", 
		description = 
			"<h4>This is an API description for following functionalities:</h4>" +
			"<ol>" +
			"<li><a href=\"/calc\" target=_blank>The calculator; able to process 3 arithmetics or select one and use multiple values.</a></li>" +
			"<li><a href=\"/rspgame\" target=_blank>The Rock Scissor Paper; standard RSP game.</a></li>" +
			"<li><a href=\"/csvtojson?filename=sample.csv\" target=_blank>CSV to JSON; parse a simple CSV file to JSON</a></li>" +
			"<li><a href=\"/pic\" target=_blank>Random picture; return a random picture</a></li>" + 
			"</ol>"
		))



@SpringBootApplication
public class FinalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAssignmentApplication.class, args);
	}

}
