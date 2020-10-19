package gameapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * Configuration file reads input data for the game from JSON file.
 **/

public class GameConfig {

	private List<Player> playersList;
	private String gameName;

	public GameConfig(File file) throws Exception {
		if(file!= null && file.isFile()) {
			initializePlayers(file);
		} else {
			throw new FileNotFoundException();
		}
	}
	

	private void initializePlayers(File file) throws Exception {
		this.playersList = new ArrayList<Player>();
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) object;
			gameName = (String) jsonObject.get("game-label");
			long numOfPlayers = (Long) jsonObject.get("num-of-players");
			// players-info
			// Iterate over players-info array
			JSONArray playerList = (JSONArray) jsonObject.get("player-info");
			if (playerList.size() < numOfPlayers) {
				System.out.println("Config Error :: Please provide player-info for all players");
			} else {
				// Iterate over players array
				for (int pl = 0; pl < numOfPlayers; pl++) {
					playersList.add(parsePlayerObject((JSONObject) playerList.get(pl)));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getGameName() {
		return gameName;
	}


	public List<Player> getPlayersList() {
		return playersList;
	}

	private Player parsePlayerObject(JSONObject playerJSONMap) throws Exception{
		String playerName =  (String)playerJSONMap.get("name");
		List<String> playerOptions = new ArrayList<>();
		if (playerJSONMap.get("options") instanceof List) {
			((List<?>)playerJSONMap.get("options")).forEach(option->{
				if(option instanceof String) {
					playerOptions.add((String)option);
				} else {
					System.err.println("Please provide Player options in String format");
				}
			});
		} else {
			System.err.println("Please provide Player options as List of String");
		}
		return new Player(playerName, playerOptions);
	}
}
