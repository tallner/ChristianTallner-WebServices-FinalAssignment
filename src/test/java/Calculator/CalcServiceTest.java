package Calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.Calculator.CalcService;


@SpringBootTest
public class CalcServiceTest {
	
	private CalcService sut;

	@Before
	public void setUp() {
		sut = new CalcService();
	}
	
	
	
	//test for correct result
	@Test
	public void testSubSucc() {
		String actual = sut.Substraction("5", "4");
		String expected = "{ \"Result\":\"1\"}";
		assertEquals(expected, actual);
	}
	
	//test for wrong result
	@Test
	public void testSubFail() {
		String actual = sut.Substraction("5","6");
		String expected = "{ \"Result\":\"56\"}";
		assertNotEquals(expected, actual);
	}
	
	//test for wrong input format
	@Test//(expected = NumberFormatException.class)
	public void testSub_badInput() {
		String actual = sut.Multiplication("a", "4");
		String expected = "Check your inputs";
		assertEquals(expected, actual);
	}
	
	
	
	
	
	@Test
	public void testAddSucc() {
		String actual = sut.Addition("5", "4");
		String expected = "{ \"Result\":\"9\"}";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddFail() {
		String actual = sut.Addition("5","6");
		String expected = "{ \"Result\":\"56\"}";
		assertNotEquals(expected, actual);
	}
	
	//test for wrong input format
	@Test//(expected = NumberFormatException.class)
	public void testAdd_badInput() {
		String actual = sut.Multiplication("a", "4");
		String expected = "Check your inputs";
		assertEquals(expected, actual);
	}
	
	
	
	
	
	@Test
	public void testMultSucc() {
		String actual = sut.Multiplication("5", "4");
		String expected = "{ \"Result\":\"20\"}";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultFail() {
		String actual = sut.Multiplication("5","6");
		String expected = "{ \"Result\":\"56\"}";
		assertNotEquals(expected, actual);
	}
	
	//test for wrong input format
	@Test//(expected = NumberFormatException.class)
	public void testMult_badInput() {
		String actual = sut.Multiplication("a", "4");
		String expected = "Check your inputs";
		assertEquals(expected, actual);
	}
		
		
		
		
		
		
	
	@Test
	public void testMultValSucc() {
		String[] values = {"10", "10", "10", "10"};
		
		String actualAdd = sut.MultVal("add", values);
		String actualMult = sut.MultVal("mult", values);
		String actualSub = sut.MultVal("sub", values);
		
		String expectedAdd = "{ \"Result\":\"40\"}";
		String expectedMult = "{ \"Result\":\"10000\"}";
		String expectedSub = "{ \"Result\":\"-20\"}";
		
		assertEquals(actualAdd, expectedAdd);
		assertEquals(actualMult, expectedMult);
		assertEquals(actualSub, expectedSub);
	}
	
	@Test
	public void testMultValFail() {
		String[] values = {"13", "10", "10", "10"};
		
		String actualAdd = sut.MultVal("add", values);
		String actualMult = sut.MultVal("mult", values);
		String actualSub = sut.MultVal("sub", values);
		
		String expectedAdd = "{ \"Result\":\"40\"}";
		String expectedMult = "{ \"Result\":\"10000\"}";
		String expectedSub = "{ \"Result\":\"-20\"}";
		
		assertNotEquals(actualAdd, expectedAdd);
		assertNotEquals(actualMult, expectedMult);
		assertNotEquals(actualSub, expectedSub);
	}
	
	//test for wrong input format
	@Test//(expected = NumberFormatException.class)
	public void testMultValBadInput() {
		String[] values = {"a", "b", "c", "d"};
		
		String actualAdd = sut.MultVal("add", values);
		String actualMult = sut.MultVal("mult", values);
		String actualSub = sut.MultVal("sub", values);

		String expected = "Check your values inputs";
		assertEquals(expected, actualAdd);
		assertEquals(expected, actualMult);
		assertEquals(expected, actualSub);
		
	}
	
}
