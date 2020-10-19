package gameapp;

import java.util.ArrayList;
import java.util.List;

import gameapp.Game.Choice;
import gameapp.Game.ROUND_RESULT;

/**
 * Player POJO class.
 */

public class Player {

	List<Choice> choices;
	String name;
	Score score;

	public Player(String name, List<String> choicesStr) {
		this.name = name;
		this.score = new Score();
		if (choicesStr != null) {
			this.choices = new ArrayList<Choice>();
			choicesStr.forEach(choiceStr -> {
				this.choices.add(Choice.valueOf(choiceStr));
			});
		} else {
			throw new IllegalArgumentException("");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public Choice play() {
		return this.choices.get(((int) (Math.round(Math.random() * 1000) % this.choices.size())));
	}

	public Score getScore() {
		return score;
	}

	public void updateScore(ROUND_RESULT result) {
		score.update(result);
	}

}
