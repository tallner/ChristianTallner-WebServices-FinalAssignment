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
		sut = "http://localhost:8080/randpic";
	}
	
	@Test //Only test jpg files
	public void testHeaderBytes() throws IOException {
		// Start bytes of JPG is FF D8 FF, but UTF-16 format adds FE FF as a format identifier, so I add it in the sequence
		byte[] JPEG_HEADER = new byte[] {(byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte)0xD8, (byte)0xFF};

		var img = HttpHelper.UrlResponse(sut, "GET", null, "UTF-16");
		byte[] imgBytes = img.getBytes("UTF-16");
		
		for (int i = 0; i < JPEG_HEADER.length ; i++) {
			if (imgBytes[i] != JPEG_HEADER[i] ) assertTrue(false); 
		}
		
		assertTrue(true);
	}

}
