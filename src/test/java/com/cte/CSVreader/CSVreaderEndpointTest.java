package com.cte.CSVreader;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.HttpHelper;

@SpringBootTest
public class CSVreaderEndpointTest {

	private String sut;
	
	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}
	
	@Test //file not found
	public void test() throws IOException {
		String fileName = "badName.csv";
		
		String expected = "[\"File not found\"]";

		String url = sut + "/csvtojson";
		String body = "?filename=" + fileName;
		String query = url + body;
		

		String actual = HttpHelper.UrlResponse(query, "get", null);
		
		
		assertEquals(actual, expected);
	}

}
