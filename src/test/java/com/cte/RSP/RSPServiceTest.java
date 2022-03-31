package com.cte.RSP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.RSP.RSPService;

@SpringBootTest
public class RSPServiceTest {
	
	private RSPService sut;

	@Before
	public void setUp() {
		sut = new RSPService();
	}
	
	
	@Test
	public void testCalcWinner() {
		String actual = sut.calculateScore("rock", "scissors");
		String expected =
		"{\"Player1_Move\": \"rock\",\"Player2_Move\": \"scissors\",\"Player1_Score\": \"1\",\"Player2_Score\": \"0\"}";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalcWinnerBadInput() {
		String actual = sut.calculateScore("rocky", "scissors");
		String expected = "[ \" Check your input values \" ]";
		String notExpected =
		"{\"Player1_Move\": \"rock\",\"Player2_Move\": \"scissors\",\"Player1_Score\": \"1\",\"Player2_Score\": \"0\"}";
		
		assertEquals(expected, actual);
		assertNotEquals(notExpected, actual);
	}

}
