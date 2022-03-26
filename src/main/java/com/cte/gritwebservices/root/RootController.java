package com.cte.gritwebservices.root;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class RootController {
	
	//start page
		@Hidden
		@RequestMapping(
				value = "/", 
				method = RequestMethod.GET, 
				produces = MediaType.TEXT_HTML_VALUE)
		public String start() {
			String result = "";
			result += "<html><head><title>Christian Tallner Final Assignment Web Services</title></head>";
			result += "<body>";
			result += "<h4>This is the landing page</h4>";
			result += "<br>";
			result += "<h4>Create links for the other parts</h4>";
			result += "<br>";
			result += "<ul>";
			result += " <li><a href=http://localhost:8080/apiDoc target=_blank > API Documentation, graphical </a></li>"
					+ " <li><a href=http://localhost:8080/v3/api-docs target=_blank > API Documentation, JSON format </a></li>"
					+ " <li><a href=\"/calculator\">The Calculator!</a></li> "
					+ " <li><a href=\"/rsp\">The RSP Game!</a></li> "
					+ " <li><a href=\"/csv\">The read CSV tester!</a></li> "
					+ " <li><a href=\"/pic\">The picture reader!</a></li> ";
			result += "</ul>";
			
			
			

			result += "</body></html>";
			return result;
		}
		
		@Hidden
		@RequestMapping(
				value = "/error",
				method = RequestMethod.GET,
				produces = MediaType.TEXT_HTML_VALUE)
		public String error() {
			return "Wrong path" + "<br>" + start();
		}

}
