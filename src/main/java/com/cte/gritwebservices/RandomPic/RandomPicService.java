package com.cte.gritwebservices.RandomPic;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.io.ClassPathResource;

public class RandomPicService {
	
	public ClassPathResource generateRandomPicture() {
		
		int min = 1;
		int max = 10;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		var imgFile = new ClassPathResource(randomNum+".jpg");
		
		return imgFile;
		
	}

}
