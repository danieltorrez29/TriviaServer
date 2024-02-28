package co.edu.uptc.model.business;

import co.edu.uptc.model.structures.AVLTree;

/**
 * 
 * Difficulty class
 * 
 * @author Daniel Torres
 */

public class Difficulty {

	/**
	 * Level
	 */

	private int level;

	/**
	 * Categorie tree
	 */

	private AVLTree<Categorie> categories;

	/**
	 * Constructor method
	 * 
	 * @param level
	 * @param categories
	 */

	public Difficulty(int level, AVLTree<Categorie> categories) {
		this.level = level;
		this.categories = categories;
	}

	/**
	 * getLevel method
	 * 
	 * @return level
	 */

	public int getLevel() {
		return level;
	}

	/**
	 * getCategories method
	 * 
	 * @return categories
	 */

	public AVLTree<Categorie> getCategories() {
		return categories;
	}

	/**
	 * 
	 * searchCategorie Categorie method
	 * 
	 * @param name
	 * @return Categorie
	 */

	public Categorie searchCategorie(String name) {
		return categories.search(new Categorie(name, null));
	}
}