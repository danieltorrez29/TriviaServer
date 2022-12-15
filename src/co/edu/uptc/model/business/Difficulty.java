package co.edu.uptc.model.business;

import co.edu.uptc.model.structures.AVLTree;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description Difficulty Class
 */

public class Difficulty {

	/**
	 * Attribute declaration
	 */

	private int level;
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