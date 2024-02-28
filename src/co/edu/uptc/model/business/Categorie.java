package co.edu.uptc.model.business;

import co.edu.uptc.model.structures.AVLTree;

/**
 * 
 * Categorie class
 * 
 * @author Daniel Torres
 */

public class Categorie {

	/**
	 * Name
	 */

	private String name;

	/**
	 * Question tree
	 */

	private AVLTree<Question> questions;

	/**
	 * Constructor method
	 * 
	 * @param name
	 * @param questions
	 */

	public Categorie(String name, AVLTree<Question> questions) {
		this.name = name;
		this.questions = questions;
	}

	/**
	 * getName method
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * getQuestions method
	 * 
	 * @return questions
	 */

	public AVLTree<Question> getQuestions() {
		return questions;
	}
}