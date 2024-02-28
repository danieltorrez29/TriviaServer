package co.edu.uptc.model.business;

/**
 * 
 * Stats class
 * 
 * @author Daniel Torres
 */

public class Stats {

	/**
	 * Level
	 */

	private String level;

	/**
	 * Categorie
	 */

	private String categorie;

	/**
	 * Correct
	 */

	private int correct;

	/**
	 * Incorrect
	 */

	private int incorrect;

	/**
	 * Score
	 */

	private int score;

	/**
	 * Accuracy
	 */

	private double accuracy;

	/**
	 * Time
	 */

	private int time;

	/**
	 * Games played
	 */

	private int gamesPlayed;

	/**
	 * Constructor method
	 * 
	 * @param level
	 * @param categorie
	 * @param correct
	 * @param incorrect
	 * @param score
	 * @param accuracy
	 * @param time
	 * @param gamesPlayed
	 */

	public Stats(String level, String categorie, int correct, int incorrect, int score, double accuracy, int time,
			int gamesPlayed) {
		super();
		this.level = level;
		this.categorie = categorie;
		this.correct = correct;
		this.incorrect = incorrect;
		this.score = score;
		this.accuracy = accuracy;
		this.time = time;
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * 
	 * Constructor method
	 */

	public Stats() {
		level = "";
		categorie = "";
		correct = 0;
		incorrect = 0;
		score = 0;
		accuracy = 0;
		time = 0;
		gamesPlayed = 0;
	}

	/**
	 * getLevel method
	 * 
	 * @return level
	 */

	public String getLevel() {
		return level;
	}

	/**
	 * setLevel method
	 * 
	 * @param level
	 */

	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * getCategorie method
	 * 
	 * @return categorie
	 */

	public String getCategorie() {
		return categorie;
	}

	/**
	 * setCategorie method
	 * 
	 * @param categorie
	 */

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * getCorrect method
	 * 
	 * @return correct
	 */

	public int getCorrect() {
		return correct;
	}

	/**
	 * setCorrect method
	 * 
	 * @param correct
	 */

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	/**
	 * getIncorrect method
	 * 
	 * @return incorrect
	 */

	public int getIncorrect() {
		return incorrect;
	}

	/**
	 * setIncorrect method
	 * 
	 * @param incorrect
	 */

	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}

	/**
	 * getScore method
	 * 
	 * @return score
	 */

	public int getScore() {
		return score;
	}

	/**
	 * setScore method
	 * 
	 * @param score
	 */

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * getAccuracy method
	 * 
	 * @return accuracy
	 */

	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * setAccuracy method
	 * 
	 * @param accuracy
	 */

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * getTime method
	 * 
	 * @return time
	 */

	public int getTime() {
		return time;
	}

	/**
	 * setTime method
	 * 
	 * @param time
	 */

	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * getGamesPlayed method
	 * 
	 * @return gamesPlayed
	 */

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * setGamesPlayed method
	 * 
	 * @param gamesPlayed
	 */

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * toString overwrite method
	 */

	@Override
	public String toString() {
		return "Stats [level=" + level + ", categorie=" + categorie + ", correct=" + correct + ", incorrect="
				+ incorrect + ", score=" + score + ", accuracy=" + accuracy + ", time=" + time + "]";
	}
}