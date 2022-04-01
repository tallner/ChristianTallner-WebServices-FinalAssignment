package com.cte.gritwebservices.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.util.StreamUtils;
import org.springframework.core.io.ClassPathResource;




@RestController
public class CSVController {
		
		@Operation(summary = "Convert CSV file to JSON", description = "Use sample.csv to test", tags="CSV to JSON")
		@RequestMapping(
				value = "/csvtojson",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public String csvttojson(String filename) throws FileNotFoundException, IOException {
			CSVService myReader = new CSVService();
			
			String text = myReader.JSONparser(filename);
			return text;
		}

}
