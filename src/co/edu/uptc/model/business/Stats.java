package co.edu.uptc.model.business;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description Stats Class
 */

public class Stats {

	/**
	 * Attribute declaration
	 */

	private String level;
	private String categorie;
	private int correct;
	private int incorrect;
	private int score;
	private double accuracy;
	private int time;

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
	 */

	public Stats(String level, String categorie, int correct, int incorrect, int score, double accuracy, int time) {
		this.level = level;
		this.categorie = categorie;
		this.correct = correct;
		this.incorrect = incorrect;
		this.score = score;
		this.accuracy = accuracy;
		this.time = time;
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
	 * toString overwrite method
	 */

	@Override
	public String toString() {
		return "Stats [level=" + level + ", categorie=" + categorie + ", correct=" + correct + ", incorrect="
				+ incorrect + ", score=" + score + ", accuracy=" + accuracy + ", time=" + time + "]";
	}
}