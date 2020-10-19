package gameapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameapp.Game.ROUND_RESULT;

/**
 * Unit test for Score.
 */
public class ScoreTest {

	@Test
	public void testNumberOfWins() {
		Score score = new Score();
		long noOfWins = score.getNoOfWins();
		score.update(ROUND_RESULT.WIN);
		assertEquals(score.getNoOfWins(), noOfWins + 1);
	}

	@Test
	public void testNumberOfFails() {
		Score score = new Score();
		long noOfFails = score.getNoOfFails();
		score.update(ROUND_RESULT.LOSE);
		assertEquals(score.getNoOfFails(), noOfFails + 1);
	}

	@Test
	public void testNumberOfTies() {
		Score score = new Score();
		long noOfTies = score.getNoOfTies();
		score.update(ROUND_RESULT.TIE);
		assertEquals(score.getNoOfTies(), noOfTies + 1);
	}
}
