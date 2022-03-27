package com.cte.gritwebservices.RSP;

public class RSPPlayerModel {
	private String selectedMove; //this is the move the player makes
	private int nrOfWins; //this is nr of wins
	private int nrOfLost; //this is nr of loss
	private int nrOfTie; //this is nr of draw
	private int currentScore;

	public RSPPlayerModel() {}
	

	public String getSelectedMove() {
		return selectedMove;
	}

	public void setSelectedMove(String selectedMove) {
		this.selectedMove = selectedMove;
	}

	public void increaseNrOfWins() {
		this.nrOfWins += 1;
	}
	
	public int getNrOfWins() {
		return nrOfWins;
	}
	
	public void increaseNrOfLost() {
		this.nrOfLost += 1;
	}
	
	public int getNrOfLost() {
		return this.nrOfLost;
	}
	
	public void increaseNrOfTie() {
		this.nrOfTie += 1;
	}
	
	public int getNrOfTie() {
		return this.nrOfTie;
	}
	
	public int getCurrentScore() {
		return this.currentScore;
	}
	
	public void setScore() {
		this.currentScore += 1;
	}
	
	public void resetScore() {
		this.currentScore = 0;
	}
	
	
	

}
