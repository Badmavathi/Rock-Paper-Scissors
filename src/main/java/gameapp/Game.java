package gameapp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a Rock-Paper-Scissors game.
 *
 * The game takes two players A and B.
 *
 * Based on both players turn, winner is decided.
 *
 */

public class Game {

	private static Map<Set<Choice>, Choice> ruleMap;

	Player playerA;
	Player playerB;
	int numberOfGames;

	enum Choice {
		ROCK("ROCK"), PAPER("PAPER"), SCISSORS("SCISSORS");

		private String choice;

		Choice(String choice) {
			this.choice = choice;
		}

		public String toString() {
			return this.choice;
		}
	}

	public enum ROUND_RESULT {
		WIN, LOSE, TIE
	}

	public Game(Player pA, Player pB, int tot) {
		this.playerA = pA;
		this.playerB = pB;
		this.numberOfGames = tot;
	}

	public void start() {
		for (int rounds = 1; rounds <= numberOfGames; rounds++) {
			playRound();
		}
		printResults();
	}

	public void playRound() {
		Choice choiceA = playerA.play();
		Choice choiceB = playerB.play();
		if (!choiceA.equals(choiceB)) {
			Choice winner = getRuleMap().get(new HashSet<Choice>(Arrays.asList(choiceA, choiceB)));
			if (choiceA.equals(winner)) {
				this.playerA.updateScore(ROUND_RESULT.WIN);
				this.playerB.updateScore(ROUND_RESULT.LOSE);
			} else if (choiceB.equals(winner)) {
				this.playerA.updateScore(ROUND_RESULT.LOSE);
				this.playerB.updateScore(ROUND_RESULT.WIN);
			}
		} else {
			this.playerA.updateScore(ROUND_RESULT.TIE);
			this.playerB.updateScore(ROUND_RESULT.TIE);
		}
	}

	private void printResults() {
		System.out.println("");
		System.out.println(String.format("Results after %d games: ", numberOfGames ));
		System.out.println(String.format("%s wins %d of 100 games", this.playerA.name , this.playerA.getScore().getNoOfWins()));
		System.out.println(String.format("%s wins %d of 100 games", this.playerB.name, this.playerB.getScore().getNoOfWins()));
		System.out.println(String.format("Tie: %d of 100 games", this.playerA.getScore().getNoOfTies()));
	}

	static {
		ruleMap = new HashMap<Set<Choice>, Choice>();
		ruleMap.put(new HashSet<Choice>(Arrays.asList(Choice.SCISSORS, Choice.PAPER)), Choice.SCISSORS);
		ruleMap.put(new HashSet<Choice>(Arrays.asList(Choice.ROCK, Choice.SCISSORS)), Choice.ROCK);
		ruleMap.put(new HashSet<Choice>(Arrays.asList(Choice.PAPER, Choice.ROCK)), Choice.PAPER);
	}
	public static Map<Set<Choice>, Choice> getRuleMap() {
		return ruleMap;
	}
}
