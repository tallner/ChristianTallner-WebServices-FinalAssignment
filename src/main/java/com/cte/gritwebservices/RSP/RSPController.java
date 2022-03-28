package com.cte.gritwebservices.RSP;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class RSPController {
	
	private RSPService rspGame = new RSPService(); //use the RSPmodel to set up a new game
	
	//draw the gameplan from an html file
	@Operation(summary = "Draw the gameplan", description = "Draw the gameplan as a website from an html file", tags="RockScissorsPaper")
	@RequestMapping(
			value = "/rspgame",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public void drawGamePlan(HttpServletResponse response) throws IOException{
		var website = new ClassPathResource("rsp.html");
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		StreamUtils.copy(website.getInputStream(), response.getOutputStream());
	}
	
	@Operation(summary = "Evaluate round", description = "Evaluate player inputs in this round", tags="RockScissorsPaper")
	@RequestMapping(path="/rsp", method = RequestMethod.POST)
	public String evaluateUserInput(
			String player1Move, 
			String player2Move){
		return rspGame.calculateScore(player1Move, player2Move);
	}
	
	@Operation(summary = "Total score", description = "Get total score", tags="RockScissorsPaper")
	@RequestMapping(
			path="/rsp",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public String totalScore(){
		return ObjectJson();
	}
	
	private String ObjectJson() {
		return "{"+ 
				"\"TotalNrOfGames\": \"" + rspGame.getNrOfGamesPlayed() + 
				"\"," +
				
				"\"Player 1\":" + 
					"[{"+
						"\"TotalWins\":" + "\"" + rspGame.getPlayer1TotalWins() + "\""+ 
						"," +
						"\"TotalLoss\":" + "\"" + rspGame.getPlayer1TotalLost() + "\""+ 
						"," +
						"\"TotalTie\":" + "\"" + rspGame.getPlayer1TotalTies() + "\""+
					"}]"+
				"," +
				
				"\"Player 2\":" + 
					"[{"+
						"\"TotalWins\":" + "\"" + rspGame.getPlayer2TotalWins() + "\""+ 
						"," +
						"\"TotalLoss\":" + "\"" + rspGame.getPlayer2TotalLost() + "\""+ 
						"," +
						"\"TotalTie\":" + "\"" + rspGame.getPlayer2TotalTies() + "\""+
					"}]"+
				"}";
	}
	

}
