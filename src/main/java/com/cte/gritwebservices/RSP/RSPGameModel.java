package com.cte.gritwebservices.RSP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class RSPGameModel {
	private RSPPlayerModel player1 = new RSPPlayerModel();
	private RSPPlayerModel player2 = new RSPPlayerModel();
	private int nrOfGamesPlayed;
	
	public RSPGameModel() {}

	//draw the gameplan from an html file
	public String drawGamePlan(String fileName) throws FileNotFoundException, IOException {
		String result = "";
		var webPageFile = new ClassPathResource(fileName);
		
		try (Scanner myScanner = new Scanner(webPageFile.getFile())) {
			while (myScanner.hasNextLine()) {
				result += myScanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// set the player move
	// if player is set to computer, then a random value will be set
	public void setPlayer1Move(String player1Move) {
		if (player1Move.equals("computer")) {
			this.player1.setSelectedMove(randomVal());
		}else this.player1.setSelectedMove(player1Move);
	}

	public void setPlayer2Move(String player2Move) {
		if (player2Move.equals("computer")) {
			this.player2.setSelectedMove(randomVal());
		}else this.player2.setSelectedMove(player2Move);
	}
	
	// get the move. this is used for display only
	public String getPlayer1Move() {
		return player1.getSelectedMove();
	}
	
	public String getPlayer2Move() {
		return player2.getSelectedMove();
	}
	
	// get total nr of wins. this is used for display only
	public int getPlayer1TotalWins() {
		return player1.getNrOfWins();
	}
	
	public int getPlayer2TotalWins() {
		return player2.getNrOfWins();
	}
	
	// get total nr of lost. this is used for display only
	public int getPlayer1TotalLost() {
		return player1.getNrOfLost();
	}
	
	public int getPlayer2TotalLost() {
		return player2.getNrOfLost();
	}
	
	// get total nr of ties. this is used for display only
	public int getPlayer1TotalTies() {
		return player1.getNrOfTie();
	}
	
	public int getPlayer2TotalTies() {
		return player2.getNrOfTie();
	}
	
	// get total nr of plays. this is used for display only
	public int getNrOfGamesPlayed() {
		return this.nrOfGamesPlayed;
	}
	
	// calculate gamescore
	public String calculateScore() {
		String currentScore = "";
		String winner = "";
		String player1Move = this.player1.getSelectedMove();
		String player2Move = this.player2.getSelectedMove();
		
		//reset scores if there is a winner from last round
		if (player1.getCurrentScore()==3 || player2.getCurrentScore()==3) {
			player1.resetScore();
			player2.resetScore();
		}
		
		//decide who is winner for this round
		//if winner is player 1 add score to player 1
		//if winner is player 1 add score to player 1
		switch (player1Move) {
	      case "rock": //player1
	    	  
	    	  switch (player2Move) { //player2
			      case "rock":
			    	  currentScore = "tie";
			    	  break;
			      case "scissors": 
			    	  currentScore = "player1";
			    	  break;
			      case "paper":
			    	  currentScore = "player2";
			    	  break;
			      }
	    	  
	    	  break;
	    	  
	      case "scissors": //player1
	    	  
	    	  switch (player2Move) { //player2
			      case "rock":
			    	  currentScore = "player2";
			    	  break;
			      case "scissors": 
			    	  currentScore = "tie";
			    	  break;
			      case "paper":
			    	  currentScore = "player1";
			    	  break;
			      }
	    	  break;
	    	  
	      case "paper":  //player1
	    	  switch (player2Move) { //player2
			      case "rock":
			    	  currentScore = "player1";
			    	  break;
			      case "scissors": 
			    	  currentScore = "player2";
			    	  break;
			      case "paper":
			    	  currentScore = "tie";
			    	  break;
			      }
	    	  break;
	    	  
	    }
		
		//set score for the winner
		if (currentScore.equals("player1")) {
			player1.setScore();
		}else if (currentScore.equals("player2")) {
			player2.setScore();
		}else if (currentScore.equals("tie")){
			player1.setScore();
			player2.setScore();	
		}
		
		//check if there is a winner
		//if there is a winner return this, otherwise return score
		if (player1.getCurrentScore()==3 && player2.getCurrentScore()==3) {
			winner = "tie";
			player1.increaseNrOfTie();
			player2.increaseNrOfTie();
		}else if (player1.getCurrentScore()==3) {
			winner = "player1";
			player1.increaseNrOfWins();
			player2.increaseNrOfLost();
		}else if (player2.getCurrentScore()==3) {
			winner = "player2";
			player2.increaseNrOfWins();
			player1.increaseNrOfLost();
		}else winner = "round not finished";
		
		//increase gamecounter if there is a winner
		if (player1.getCurrentScore()==3 || player2.getCurrentScore()==3) {
			this.nrOfGamesPlayed += 1;
		}
		
		//return status
		return "Player1: " + player1.getCurrentScore() + "<br>" +
				"Player2: " + player2.getCurrentScore() + "<br>" +
				"Winner:" + winner;

	}
	
	// generate random value if a computer player is set
	private String randomVal() {
		Random rn = new Random();
		int answer = rn.nextInt(3);
		String returnVal = "";
		
		switch (answer) {
			case 0:
				returnVal = "rock";
				break;
			
			case 1:
				returnVal = "scissors";
				break;
				
			case 2:
				returnVal = "paper";
				break;
	
			default:
				break;
		}
		
		return returnVal;
	}

}
