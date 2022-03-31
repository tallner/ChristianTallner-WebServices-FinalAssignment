package com.cte.gritwebservices.MyErrorController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class MyErrorController implements ErrorController {
	
	//error page
		
		@Hidden
		@RequestMapping(
				value = "/error",
				method = RequestMethod.GET,
				produces = MediaType.TEXT_HTML_VALUE)
		public String error() {
			return "Something went wrong" + errorMessage();
		}
		
		private String errorMessage() {
			String result = "<br>";
			result += "Make sure you used correct URL";
			result += "<br>";
			result += "Check documentation: ";
			result += "<li><a href=http://localhost:8080/ target=_blank> API Documentation </a></li>";
			return result;
		}

}
