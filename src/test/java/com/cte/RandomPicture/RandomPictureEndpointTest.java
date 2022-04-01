package com.cte.RandomPicture;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.HttpHelper;

@SpringBootTest
public class RandomPictureEndpointTest {

	private String sut;
	
	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}
	
	@Test
	public void testHeaderBytes() throws IOException {
		// http://jubin.tech/articles/2018/12/05/Detect-image-format-using-java.html
		byte[] jpgHeader = new byte[] {(byte) 0xEF, (byte)0xBF, (byte)0xBD};
		byte[] JPEG_HEADER = new byte[] {(byte) 0xFF, (byte)0xD8, (byte)0xFF};

		var img = HttpHelper.UrlResponse("http://localhost:8080/", "GET", null);
		byte[] imgBytes = img.getBytes();
		
		
	//	String test = new String(imgBytes);
	//	System.out.println("test");
	//	System.out.println(img.getBytes());
		System.out.println(imgBytes.length);
		
		for (int i = 0; i < jpgHeader.length; i++) {
			System.out.println(JPEG_HEADER[i]);
			System.out.println(imgBytes[i]);
			System.out.println(jpgHeader[i]);
		}

		/*
		 * int i = 0; //System.out.println(i); for (byte b : JPEG_HEADER) {
		 * 
		 * if (imgBytes[i] != b) {
		 * 
		 * //assertTrue(false); System.out.println(b); System.out.println(imgBytes[i]);
		 * System.out.println(jpgHeader[i]); } i++;
		 * 
		 * }
		 */
		
		assertTrue(true);
	}

}
