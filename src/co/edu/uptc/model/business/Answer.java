package co.edu.uptc.model.business;

/**
 * 
 * Answer class
 * 
 * @author Daniel Torres
 */

public class Answer {

	/**
	 * Statement
	 */

	private String statement;

	/**
	 * flagIsCorrect
	 */

	private boolean flagIsCorrect;

	/**
	 * flagFiftyFifty
	 */

	private boolean flagFiftyFifty;

	/**
	 * Constructor method
	 * 
	 * @param statement
	 * @param flagIsCorrect
	 * @param flagFiftyFifty
	 */

	public Answer(String statement, boolean flagIsCorrect, boolean flagFiftyFifty) {
		this.statement = statement;
		this.flagIsCorrect = flagIsCorrect;
		this.flagFiftyFifty = flagFiftyFifty;
	}

	/**
	 * getStatement method
	 * 
	 * @return statement
	 */

	public String getStatement() {
		return statement;
	}

	/**
	 * getFlagIsCorrect method
	 * 
	 * @return flagIsCorrect
	 */

	public boolean getFlagIsCorrect() {
		return flagIsCorrect;
	}

	/**
	 * getFlagFiftyFifty method
	 * 
	 * @return flagFiftyFifty
	 */

	public boolean getFlagFiftyFifty() {
		return flagFiftyFifty;
	}
}