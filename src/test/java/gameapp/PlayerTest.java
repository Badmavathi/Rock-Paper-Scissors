package gameapp;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import gameapp.Game.Choice;
import gameapp.Game.ROUND_RESULT;

/**
 * Unit test for Player.
 */
public class PlayerTest {

	@Test
	public void testPlayerChoiceArgument() {
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("PAPER");
		Player p = new Player("Player", choices);
		assertEquals(choices.get(0), p.getChoices().get(0).toString());
	}

	@Test
	public void testPlay() {
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("PAPER");
		Player p = new Player("Player", choices);
		assertEquals(p.getChoices().get(0), p.play());
	}

	@Test
	public void testUpdateScore() {
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("PAPER");
		Player p = new Player("Player", choices);
		long numOfWins = p.getScore().getNoOfWins();
		p.updateScore(ROUND_RESULT.WIN);
		assertEquals(numOfWins + 1, p.getScore().getNoOfWins());
	}

	@Test
	public void testMockPlay() {
		Player player = mock(Player.class);
		when(player.play()).thenReturn(Choice.PAPER);
		System.out.println(player.play());
		assertEquals(Choice.PAPER, player.play());
	}
	
	@Test
	public void testMockScore() {
		Player player = mock(Player.class);
		Score s = mock(Score.class);
		player.score = s;
		when(s.getNoOfWins()).thenReturn((long)1);
		player.updateScore(ROUND_RESULT.WIN);
		assertEquals(player.score.getNoOfWins(), s.getNoOfWins());
	}

}
