package gameapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Build a game in which two players compete in a game of Rock-Paper-Scissors
 * with different strategies. Who will win more rounds?
 * 
 * The rules: • Scissors beats Paper • Rock beat Scissors • Paper beats Rock •
 * If both players choose the same, the round is counted as a tie.
 * 
 * Implement two players: Player A always chooses Paper Player B chooses
 * randomly
 * 
 * The game consists of 100 rounds of above two players competing. The output of
 * the program should be like the following:
 *
 * "Player A wins 31 of 100 games" "Player B wins 37 of 100 games" "Tie: 32 of
 * 100 games"
 *
 */

public class App {
	
	public static final int TOTAL_ROUNDS = 100;
	private static final int PLAYER_A = 0;
	private static final int PLAYER_B = 1;
	private static final String configFilePath = "resources/config.json";
	
	public void run() {
		try {
			File file = new File(configFilePath);
			GameConfig gConfig = new GameConfig(file);
			List<Player> playersList = gConfig.getPlayersList();
			System.out.println("GAME : " +gConfig.getGameName());
			Game gameObj = new Game(playersList.get(PLAYER_A), playersList.get(PLAYER_B), TOTAL_ROUNDS);
			gameObj.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new App().run();
	}
}