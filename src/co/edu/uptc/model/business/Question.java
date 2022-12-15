package co.edu.uptc.model.business;

import co.edu.uptc.model.structures.AVLTree;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description Question Class
 */

public class Question {

	/**
	 * Attribute declaration
	 */

	private String statement;
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