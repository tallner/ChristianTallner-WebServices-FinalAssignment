package RSP;

import static org.junit.Assert.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import com.cte.gritwebservices.HttpHelper;

public class RSPendpointTest {

	private String sut;

	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}
	
	@Test
	public void testEvaluateEndpointBadinput() throws IOException {
		String testVar1 = "rock";
		String testVar2 = "scissors";
		
		String expected = "Check your input values";
		//String actual = "Check your input values";
		
	//	System.out.println(HttpHelper.httpPOSTtest());
		
		

		String url = sut + "/rsp";
		//String params = "?player1Move=" + testVar1 + "&player2Move=" + testVar2;
		String query = url;
		String body = "player1Move=" + testVar1 + "&player2Move=" + testVar2;
		
		String actual = HttpHelper.UrlResponse(query, "post", body);
		
		assertEquals(actual, expected);

	}
	
	
}
