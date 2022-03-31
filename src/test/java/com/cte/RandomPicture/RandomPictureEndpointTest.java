package com.cte.RandomPicture;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cte.gritwebservices.HttpHelper;

@SpringBootTest
class RandomPictureEndpointTest {

	@Test
	public void test() throws IOException {
		// http://jubin.tech/articles/2018/12/05/Detect-image-format-using-java.html
		// byte[] jpgHeader = new byte[] {(byte) 0xEF, (byte)0xBF, (byte)0xBD};
		byte[] JPEG_HEADER = new byte[] {(byte) 0xFF, (byte)0xD8, (byte)0xFF};

		var img = HttpHelper.UrlResponse("http://localhost:8080/", "GET", null);
		byte[] imgBytes = img.getBytes();
		
		String test = new String(imgBytes);
		
		System.out.println("test");
		System.out.println(test);

		int i = 0;		
		for (byte b : JPEG_HEADER) {
			if (imgBytes[i++] != b)
				assertTrue(false);
		}
		
		assertTrue(false);
	}

}
