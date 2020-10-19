package gameapp;

import gameapp.Game.ROUND_RESULT;

public class Score {

	private long noOfWins;
	private long noOfFails;
	private long noOfTies;

	public void update(ROUND_RESULT result) {
		switch (result) {
		case WIN:
			this.noOfWins++;
			break;
		case LOSE:
			this.noOfFails++;
			break;
		case TIE:
			this.noOfTies++;
			break;
		}
	}

	public long getNoOfWins() {
		return noOfWins;
	}

	public long getNoOfFails() {
		return noOfFails;
	}

	public long getNoOfTies() {
		return noOfTies;
	}

}
