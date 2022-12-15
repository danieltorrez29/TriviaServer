package co.edu.uptc.model.business;

import java.util.ArrayList;
import java.util.Collections;

import co.edu.uptc.model.persistence.JsonDifficultyTreeConstructor;
import co.edu.uptc.model.persistence.JsonUserTreeConstructor;
import co.edu.uptc.model.persistence.JsonUserTreeWriter;
import co.edu.uptc.model.structures.AVLTree;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description ServerSideGame Class
 */

public class ServerSideGame {

	/**
	 * Attribute declaration
	 */

	private AVLTree<Difficulty> questions;
	private AVLTree<User> users;

	/**
	 * Constructor method
	 */

	public ServerSideGame() {
		questions = JsonDifficultyTreeConstructor.getQuestions();
		users = JsonUserTreeConstructor.getUsers();
	}

	/**
	 * 
	 * addUser void method
	 * 
	 * @param email
	 * @param username
	 * @param password
	 */

	public void addUser(String email, String username, String password) {
		users.insert(new User(email, username, password, ProfilePicPath.getRandomProfilePicPath(), new Stats()));
		writeJsonUsers();
	}

	/**
	 * 
	 * writeJsonUsers void method
	 */

	private void writeJsonUsers() {
		JsonUserTreeWriter.writeUsers(users.traverseInOrder());
	}

	/**
	 * 
	 * searchUser User method
	 * 
	 * @param username
	 * @return
	 */

	private User searchUser(String username) {
		return users.search(new User(null, username, null, null, null));
	}

	/**
	 * 
	 * isUserRegistered boolean method
	 * 
	 * @param username
	 * @param password
	 * @return true || false
	 */

	public boolean isUserRegistered(String username, String password) {
		boolean flag = false;
		if (!username.equals("") || !password.equals("")) {
			User target = searchUser(username);
			if (target != null)
				flag = target.getPassword().equals(password) ? true : false;
		}
		return flag;
	}

	/**
	 * 
	 * isUserExist boolean method
	 * 
	 * @param username
	 * @return true || false
	 */

	public boolean isUserExist(String username) {
		boolean flag = false;
		if (!username.equals("")) {
			User target = searchUser(username);
			if (target != null)
				flag = target.getEmail().equals(username) || target.getUsername().equals(username) ? true : false;
		}
		return flag;
	}

	/**
	 * 
	 * getUser User method
	 * 
	 * @param username
	 * @return User
	 */

	public User getUser(String username) {
		return searchUser(username);
	}

	/**
	 * 
	 * updateUserStats void method
	 * 
	 * @param user
	 */

	public void updateUserStats(User user) {
		searchUser(user.getUsername()).setStats(user.getStats());
		writeJsonUsers();
	}

	/**
	 * 
	 * getRandomQuestions AVLTree<Difficulty> method
	 * 
	 * @return AVLTree<Difficulty>
	 */

	public synchronized AVLTree<Difficulty> getRandomQuestionTree() {
		AVLTree<Difficulty> randomDifficultyTree = new AVLTree<Difficulty>((x, y) -> x.getLevel() - y.getLevel());
		AVLTree<Categorie> randomCategorieTree = new AVLTree<>((x, y) -> x.getName().compareToIgnoreCase(y.getName()));
		AVLTree<Question> randomQuestionTree = new AVLTree<Question>(
				(x, y) -> x.getStatement().compareToIgnoreCase(y.getStatement()));

		Difficulty difficulty;
		AVLTree<Categorie> categorieTree;
		String categorieName = "";
		AVLTree<Question> questionTree;
		Question randomQuestion;
		boolean isQuestionExist = false;

		for (int i = 0; i < 2; i++) {
			difficulty = questions.search(new Difficulty(i, null));
			categorieTree = difficulty.getCategories();
			for (Categorie categorie : categorieTree.traverseInOrder()) {
				categorieName = categorie.getName();
				questionTree = categorie.getQuestions();
				randomQuestionTree.insert(questionTree.getRandomValue());
				for (int j = 0; j < 5; j++) {
					while (!isQuestionExist) {
						randomQuestion = questionTree.getRandomValue();
						if (!randomQuestionTree.exist(randomQuestion)) {
							isQuestionExist = true;
							randomQuestionTree.insert(randomQuestion);
						}
					}
					isQuestionExist = false;
				}
				randomCategorieTree.insert(new Categorie(categorieName, randomQuestionTree));
				randomQuestionTree = new AVLTree<Question>(
						(x, y) -> x.getStatement().compareToIgnoreCase(y.getStatement()));
			}
			randomDifficultyTree.insert(new Difficulty(i, randomCategorieTree));
			randomCategorieTree = new AVLTree<>((x, y) -> x.getName().compareToIgnoreCase(y.getName()));
		}
		return randomDifficultyTree;
	}

	/**
	 * 
	 * getTopFive ArrayList<User> method that returns best five users regarding its
	 * score
	 * 
	 * @return ArrayList<User>
	 */

	public synchronized ArrayList<User> getTopFive() {
		ArrayList<User> topFiveUsers = new ArrayList<User>();
		ArrayList<User> userList = users.traverseInOrder();
		Collections.sort(userList);
		Collections.reverse(userList);
		for (int i = 0; i < 5; i++)
			topFiveUsers.add(userList.get(i));
		return topFiveUsers;
	}
}