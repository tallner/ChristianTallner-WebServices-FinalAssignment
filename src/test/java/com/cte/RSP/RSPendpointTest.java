package com.cte.RSP;

import static org.junit.Assert.*;


import java.io.IOException;

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
		
		String actual = HttpHelper.UrlResponse(query, "post", body);

		assertNotEquals(actual, notExpected);
		//assertequals gör en reversed json för att testa detta

	}
	
	@Test
	public void testTotalScoreEndpoint() throws IOException {
		String pattern = 
				"{\"TotalNrOfGames\": \"%s\",\"Player 1\":[{\"TotalWins\":\"%s\",\"TotalLoss\":\"%s\",\"TotalTie\":\"%s\"}],\"Player 2\":[{\"TotalWins\":\"%s\",\"TotalLoss\":\"%s\",\"TotalTie\":\"%s\"}]}";
		String expectedFormat = String.format(pattern, 5,5,5,5,5,5,5);
		
		String notExpected = "[ \" Check your input values \" ]";

		String url = sut + "/rsp";
		String query = url;
		
		String actual = HttpHelper.UrlResponse(query, "get", null);

		assertNotEquals(actual, notExpected);

	}
	
	
}
