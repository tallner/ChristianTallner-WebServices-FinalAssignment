package com.cte.Calculator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.HttpHelper;

@SpringBootTest
public class CalcEndpointTest {

	private String sut;

	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}

	@Test
	public void testSubEndpoint() throws IOException {
		String baseText = "{ \"Result\":\"";

		String testVar1 = "9";
		String testVar2 = "2";
		int resultInt = Integer.valueOf(testVar1)-Integer.valueOf(testVar2);
		String expected = baseText + resultInt + "\"}";
		String notExpected = expected + " dummy";

		String url = sut + "/calc/sub";
		String params = "?nr1=" + testVar1 + "&nr2=" + testVar2;
		String query = url + params;
		String actual = HttpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, notExpected);
	}
	
	@Test
	public void testAddEndpoint() throws IOException {
		String baseText = "{ \"Result\":\"";

		String testVar1 = "9";
		String testVar2 = "2";
		int resultInt = Integer.valueOf(testVar1)+Integer.valueOf(testVar2);
		String expected = baseText + resultInt + "\"}";
		String notExpected = expected + " dummy";

		String url = sut + "/calc/add";
		String params = "?nr1=" + testVar1 + "&nr2=" + testVar2;
		String query = url + params;
		String actual = HttpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, notExpected);
	}
	
	@Test
	public void testMultEndpoint() throws IOException {
		String baseText = "{ \"Result\":\"";

		String testVar1 = "9";
		String testVar2 = "2";
		int resultInt = Integer.valueOf(testVar1)*Integer.valueOf(testVar2);
		String expected = baseText + resultInt + "\"}";
		String notExpected = expected + " dummy";

		String url = sut + "/calc/mult";
		String params = "?nr1=" + testVar1 + "&nr2=" + testVar2;
		String query = url + params;
		String actual = HttpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, notExpected);
	}
	
	@Test
	public void testMultValEndpoint() throws IOException {
		
		String baseText = "{ \"Result\":\"";
		String values = "10,10,10,10";
		String [] arithmetics = {"sub","add","mult"};
		String [] result = {"-20","40","10000"};
		
		String [] expected = {
				baseText + result[0] + "\"}",
				baseText + result[1] + "\"}",
				baseText + result[2] + "\"}"};		
		String [] notExpected = {
				baseText + result[0] + "dummy",
				baseText + result[1] + "dummy",
				baseText + result[2] + "dummy"};

		String url = sut + "/calc/multVal/";
		
		String paramsSub = arithmetics[0] + "/" + values;
		String paramsAdd = arithmetics[1] + "/" + values;
		String paramsMult = arithmetics[2] + "/" + values;
		String querySub = url + paramsSub;
		String queryAdd = url + paramsAdd;
		String queryMult = url + paramsMult;
		String actualSub = HttpHelper.UrlResponse(querySub, "get", null);
		String actualAdd = HttpHelper.UrlResponse(queryAdd, "get", null);
		String actualMult = HttpHelper.UrlResponse(queryMult, "get", null);
		
		assertEquals(actualSub, expected[0]);
		assertNotEquals(actualSub, baseText);
		assertNotEquals(actualSub, notExpected);
		
		assertEquals(actualAdd, expected[1]);
		assertNotEquals(actualAdd, baseText);
		assertNotEquals(actualAdd, notExpected);
		
		assertEquals(actualMult, expected[2]);
		assertNotEquals(actualMult, baseText);
		assertNotEquals(actualMult, notExpected);
	}

}
