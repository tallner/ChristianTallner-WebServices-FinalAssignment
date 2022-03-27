package com.cte.gritwebservices.Calculator;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;


@RestController
public class CalcController implements ErrorController {
	
	private CalcService myCalcService = new CalcService();
	
	//start page
	@Hidden
	@RequestMapping(
			value = "/calc", 
			method = RequestMethod.GET, 
			produces = MediaType.TEXT_HTML_VALUE)
	public String start() {
		String result = "";
		result += "<html><head><title>This is my calculator</title></head>";
		result += "<body>";
		result += "<h2>This is my calculator start page</h2>";
		result += "<h3>Following functions can be used from the URL</h3>";
		result += "<h4>Substraction, eg http://localhost:8080/calc/sub?nr1=XX&nr2=YY</h4>";
		result += "<h4>Addition, eg http://localhost:8080/calc/add?nr1=XX&nr2=YY</h4>";
		result += "<h4>Multiplication, eg http://localhost:8080/calc/mult?nr1=XX&nr2=YY</h4>";
		result += "<h4>Selected arithmetics, eg http://localhost:8080/calc/multVal/sub/nr1,nr2,nrAny</h4>";
		result += "<h4>Selected arithmetics, eg http://localhost:8080/calc/multVal/add/nr1,nr2,nrAny</h4>";
		result += "<h4>Selected arithmetics, eg http://localhost:8080/calc/multVal/mult/nr1,nr2,nrAny</h4>";
		result += "</body></html>";
		return result;
	}
	
	//substraction operation of two values
	@Operation(summary = "Substraction GET request", description = "Substraction of two values", tags="Single arithmetics")
	@RequestMapping(value="/calc/sub",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sub(String nr1, String nr2) {
		 return myCalcService.Substraction(nr1, nr2);
	}
	
	//addition operation of two values
	@Operation(summary = "Addition GET request", description = "Addition of two values", tags="Single arithmetics")
	@RequestMapping(value="/calc/add",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String add(String nr1, String nr2) {
		return myCalcService.Addition(nr1, nr2);
	}
	
	//multiplication of two values
	@Operation(summary = "Multiplication GET request", description = "Multiplication of two values", tags="Single arithmetics")
	@RequestMapping(value="/calc/mult",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String mult(String nr1, String nr2) {		 
		return myCalcService.Multiplication(nr1, nr2);
	}
	
	//user can select sub add or mult and any number of input variables
	@Operation(summary = "Select arithmetics GET request", description = "Choose arithmetic in URL", tags="Multiple arithmetics")
	@RequestMapping(value="/calc/multVal/{type}/{values}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String multVal(@PathVariable String type, @PathVariable String[] values){	 
		return myCalcService.MultVal(type, values);
	}
	

}
