package com.cte.gritwebservices.RandomPic;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class RandomPicController {
	
	@Operation(summary = "Random picture", description = "Returns a random picture from a local folder", tags="Random picture")
	@RequestMapping(
			value="/randpic", 
			method = RequestMethod.GET, 
			produces = MediaType.IMAGE_JPEG_VALUE)
	public void img(HttpServletResponse response) throws IOException {
		
		RandomPicService randomPic = new RandomPicService();

		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(randomPic.generateRandomPicture().getInputStream(), response.getOutputStream());
	}

}
