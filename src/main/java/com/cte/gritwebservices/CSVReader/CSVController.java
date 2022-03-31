package com.cte.gritwebservices.CSVReader;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.util.StreamUtils;
import org.springframework.core.io.ClassPathResource;




@RestController
public class CSVController {

		@RequestMapping(
				value = "/csvtest",
				method = RequestMethod.GET)
		public String root() {
			return "Welcome to my web service!";
		}

		@RequestMapping(
				value = "/csvtestt",
				method = RequestMethod.GET,
				produces = MediaType.TEXT_PLAIN_VALUE)
		public void showCsvFile(HttpServletResponse response) throws IOException {
			var csvFile = new ClassPathResource("sample.csv");
			
			response.setContentType(MediaType.TEXT_PLAIN_VALUE);
			StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
		}
		
		@RequestMapping(
				value = "/csvtesttt",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public String showCsvFileScanner() throws IOException {
			CSVService myReader = new CSVService();
			
			String text = myReader.readFile("sample.csv");
			return text;
		}
	

}
