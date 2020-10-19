package gameapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.Test;
import gameapp.Game.Choice;

/**
 * Unit test for Game logic.
 */
public class GameLogicTest {

	@Test
	public void scissorsVsPaperShouldBeScissors() {
		assertEquals(Choice.SCISSORS,
				Game.getRuleMap().get(new HashSet<Choice>(Arrays.asList(Choice.SCISSORS, Choice.PAPER))));
	}

	@Test
	public void rockVsScissorsShouldGiveRock() {
		assertEquals(Choice.ROCK, 
				Game.getRuleMap().get(new HashSet<Choice>(Arrays.asList(Choice.ROCK, Choice.SCISSORS))));
	}

	@Test
	public void paperVsRockShouldGivePaper() {
		assertEquals(Choice.PAPER, 
				Game.getRuleMap().get(new HashSet<Choice>(Arrays.asList(Choice.PAPER, Choice.ROCK))));
	}

	@Test
	public void paperVsScissorsShouldGiveScissors() {
		assertEquals(Choice.SCISSORS,
				Game.getRuleMap().get(new HashSet<Choice>(Arrays.asList(Choice.PAPER, Choice.SCISSORS))));
	}

	@Test
	public void rockVsRockShouldBeNone() {
		assertNull(Game.getRuleMap().get(new HashSet<Choice>(Arrays.asList(Choice.ROCK, Choice.ROCK))));
	}
	
}
