package co.edu.uptc.model.business;

import co.edu.uptc.model.structures.AVLTree;

/**
 * 
 * Question class
 * 
 * @author Daniel Torres
 */

public class Question {

	/**
	 * Statement
	 */

	private String statement;

	/**
	 * Answer tree
	 */

	private AVLTree<Answer> answers;

	/**
	 * Constructor method
	 * 
	 * @param statement
	 * @param answers
	 */

	public Question(String statement, AVLTree<Answer> answers) {
		this.statement = statement;
		this.answers = answers;
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
	 * getAnswers method
	 * 
	 * @return answers
	 */

	public AVLTree<Answer> getAnswers() {
		return answers;
	}
}