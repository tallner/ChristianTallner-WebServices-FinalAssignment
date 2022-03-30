package CSVReader;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.print.attribute.standard.Media;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


import org.springframework.util.StreamUtils;


public class CSVController {
	
	@RestController
	public class dataController implements ErrorController {

		@RequestMapping(
				value = "/csv",
				method = RequestMethod.GET)
		public String root() {
			return "Welcome to my web service!";
		}

		@RequestMapping(
				value = "/csv/ShowFile",
				method = RequestMethod.GET,
				produces = MediaType.TEXT_PLAIN_VALUE)
		public void showCsvFile(HttpServletResponse response) throws IOException {
			var csvFile = new ClassPathResource("sample.csv");
			
			response.setContentType(MediaType.TEXT_PLAIN_VALUE);
			StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
		}
		
		@RequestMapping(
				value = "/showCsvFileScanner",
				method = RequestMethod.GET)
		public String showCsvFileScanner() throws IOException {
			CSVService myReader = new CSVService();
			
			String text = myReader.readFile("sample.csv");
			return text;
		}
	}

}
