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
	
	private RSPGameModel rspGame = new RSPGameModel(); //use the RSPmodel to set up a new game
	
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
		
		// validate input
		if (
				(!player1Move.equals("rock") &&
				!player1Move.equals("scissors") &&
				!player1Move.equals("paper") &&
				!player1Move.equals("computer"))
				||
				(!player2Move.equals("rock") &&
				!player2Move.equals("scissors") &&
				!player2Move.equals("paper") &&
				!player2Move.equals("computer"))
			)
		{
			return "Check your input values";
		}
		
		// set the moves to the game model that calculates 
		// the scores and returns it in string format
		rspGame.setPlayer1Move(player1Move);
		rspGame.setPlayer2Move(player2Move);
		String currentResult = rspGame.calculateScore();
		
		return 
				"Player1: " + rspGame.getPlayer1Move() + "<br>" + 
				"Player2: " + rspGame.getPlayer2Move() + "<br>" +
				"<br>" +
				"Current score:" + "<br>" + currentResult + "<br>" + "<br>" + 
				"</form>" +
				"<form method=\"GET\" action=\"http://localhost:8080/rspgame\">" +
				"<input type=\"submit\" value=\"NEXT ROUND\">" +
				"</form>";
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
