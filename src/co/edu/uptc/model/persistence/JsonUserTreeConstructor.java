package co.edu.uptc.model.persistence;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.edu.uptc.model.business.Stats;
import co.edu.uptc.model.business.User;
import co.edu.uptc.model.structures.AVLTree;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description JsonUserTreeConstructor Class
 */

public class JsonUserTreeConstructor {

	/**
	 * 
	 * getUsers AVLTree<User> method that builds a User AVLTree from a json file
	 * 
	 * @return AVLTree<User>
	 */

	public static AVLTree<User> getUsers() {
		AVLTree<User> userTree = new AVLTree<User>((x, y) -> x.getUsername().compareTo(y.getUsername()));
		String jsonString = "";
		String email = "";
		String username = "";
		String password = "";
		String profilePicPath = "";
		String level = "";
		String categorie = "";
		int correct = 0;
		int incorrect = 0;
		int score = 0;
		double accuracy = 0;
		int time = 0;
		try {
			jsonString = Files.readString(Path.of("resources/data/users.json"), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonArray userArray = JsonParser.parseString(jsonString).getAsJsonArray();
		for (JsonElement userElement : userArray) {
			JsonObject userObject = userElement.getAsJsonObject();

			email = userObject.get("email").getAsString();
			username = userObject.get("username").getAsString();
			password = userObject.get("password").getAsString();
			profilePicPath = userObject.get("profilePicPath").getAsString();

			JsonObject statsObject = userObject.get("stats").getAsJsonObject();

			level = statsObject.get("level").getAsString();
			categorie = statsObject.get("categorie").getAsString();
			correct = statsObject.get("correct").getAsInt();
			incorrect = statsObject.get("incorrect").getAsInt();
			score = statsObject.get("score").getAsInt();
			accuracy = statsObject.get("accuracy").getAsDouble();
			time = statsObject.get("time").getAsInt();

			userTree.insert(new User(email, username, password, profilePicPath,
					new Stats(level, categorie, correct, incorrect, score, accuracy, time)));
		}
		return userTree;
	}
}