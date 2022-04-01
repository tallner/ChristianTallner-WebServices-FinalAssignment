package com.cte.RSP;

import static org.junit.Assert.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.HttpHelper;

@SpringBootTest
public class RSPendpointTest {

	private String sut;

	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}
	
	@Test
	public void testEvaluateEndpoint() throws IOException {
		String testVar1 = "rock";
		String testVar2 = "scissors";
		
		String notExpected = "[ \" Check your input values \" ]";

		String url = sut + "/rsp";
		String query = url;
		String body = "player1Move=" + testVar1 + "&player2Move=" + testVar2;
		
		String actual = HttpHelper.UrlResponse(query, "post", body, "UTF-8");
		System.out.println(actual);

		assertNotEquals(actual, notExpected);


	}
	
	@Test
	public void testTotalScoreEndpoint() throws IOException {
		String expectedStart = "{\"TotalNrOfGames\": ";//\"666\",\"Player 1\":[{\"TotalWins\":\"666\",\"TotalLoss\":\"666\",\"TotalTie\":\"666\"}],\"Player 2\":[{\"TotalWins\":\"666\",\"TotalLoss\":\"666\",\"TotalTie\":\"666\"}]}";
		String actualStart = ""; 
		
		String notExpected = "[ \" Check your input values \" ]";

		String url = sut + "/rsp";
		String query = url;
		
		String actual = HttpHelper.UrlResponse(query, "get", null, "UTF-8");
		
		//Check if the start of the returned values is OK, if so assume it is ok :)
		for (int i = 0; i < 19; i++) {
			actualStart+=actual.charAt(i);	
		}
		

		assertEquals(actualStart, expectedStart);
		assertNotEquals(actual, notExpected);

	}
	
	
}
