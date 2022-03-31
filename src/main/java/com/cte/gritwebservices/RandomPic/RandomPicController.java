package com.cte.gritwebservices.RandomPic;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping
public class RandomPicController {
	
	@RequestMapping(
			value="/randpic", 
			method = RequestMethod.GET, 
			produces = MediaType.IMAGE_JPEG_VALUE)
	public void img(HttpServletResponse response) throws IOException {
		
		int min = 1;
		int max = 10;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		System.out.println("test"+randomNum);
		
		var imgFile = new ClassPathResource("1.jpg");
		System.out.println(imgFile.getPath());
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

}
