package co.edu.uptc.model.business;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description Answer Class
 */

public class Answer {

	/**
	 * Attribute declaration
	 */

	private String statement;
	private boolean flagIsCorrect;
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