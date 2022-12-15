package co.edu.uptc.model.persistence;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.edu.uptc.model.business.Answer;
import co.edu.uptc.model.business.Categorie;
import co.edu.uptc.model.business.Difficulty;
import co.edu.uptc.model.business.Question;
import co.edu.uptc.model.structures.AVLTree;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description JsonDifficultyTreeConstructor Class
 */

public class JsonDifficultyTreeConstructor {

	/**
	 * 
	 * getQuestions AVLTree<Difficulty> method that builds a Difficulty AVLTree from
	 * a json file
	 * 
	 * @return AVLTree<Difficulty>
	 */

	public static AVLTree<Difficulty> getQuestions() {
		AVLTree<Difficulty> difficultyTree = new AVLTree<Difficulty>((x, y) -> x.getLevel() - y.getLevel());
		AVLTree<Categorie> easyCategorieTree = new AVLTree<Categorie>(
				(x, y) -> x.getName().compareToIgnoreCase(y.getName()));
		AVLTree<Categorie> hardCategorieTree = new AVLTree<Categorie>(
				(x, y) -> x.getName().compareToIgnoreCase(y.getName()));
		AVLTree<Question> questionTree;
		AVLTree<Answer> answerTree;
		String jsonString = "";
		String categorie = "";
		String statement = "";
		int level = 0;
		try {
			jsonString = Files.readString(Path.of("resources/data/questions.json"), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonArray levelArray = JsonParser.parseString(jsonString).getAsJsonArray();
		for (JsonElement levelElement : levelArray) {
			JsonObject levelObject = levelElement.getAsJsonObject();

			categorie = levelObject.get("categorie").getAsString();
			level = levelObject.get("level").getAsInt();

			JsonArray questionArray = levelObject.getAsJsonArray("questions");

			questionTree = new AVLTree<Question>((x, y) -> x.getStatement().compareToIgnoreCase(y.getStatement()));

			for (JsonElement questionElement : questionArray) {
				JsonObject questionObject = questionElement.getAsJsonObject();

				statement = questionObject.get("statement").getAsString();

				JsonArray answerArray = questionObject.getAsJsonArray("answers");

				answerTree = new AVLTree<Answer>((x, y) -> x.getStatement().compareToIgnoreCase(y.getStatement()));

				for (JsonElement answerElement : answerArray) {
					JsonObject answerObject = answerElement.getAsJsonObject();

					answerTree.insert(new Answer(answerObject.get("statement").getAsString(),
							answerObject.get("flagIsCorrect").getAsBoolean(),
							answerObject.get("flagFiftyFifty").getAsBoolean()));
				}
				questionTree.insert(new Question(statement, answerTree));
			}
			if (level == 0) {
				easyCategorieTree.insert(new Categorie(categorie, questionTree));
			} else {
				hardCategorieTree.insert(new Categorie(categorie, questionTree));
			}
		}
		difficultyTree.insert(new Difficulty(0, easyCategorieTree));
		difficultyTree.insert(new Difficulty(1, hardCategorieTree));
		return difficultyTree;
	}

	/**
	 * 
	 * createJsonString String method that builds json String from a Difficulty
	 * AVLTree
	 * 
	 * @param difficultyTree
	 * @return String
	 */

	public static String createJsonString(AVLTree<Difficulty> difficultyTree) {
		JsonArray difficultyArray = new JsonArray();
		for (Difficulty difficulty : difficultyTree.traverseInOrder()) {
			for (Categorie categorie : difficulty.getCategories().traverseInOrder()) {

				JsonObject difficultyObject = new JsonObject();
				difficultyObject.addProperty("categorie", categorie.getName());
				difficultyObject.addProperty("level", difficulty.getLevel());

				JsonArray questionArray = new JsonArray();

				for (Question question : categorie.getQuestions().traverseInOrder()) {

					JsonObject questionObject = new JsonObject();
					questionObject.addProperty("statement", question.getStatement());

					JsonArray answerArray = new JsonArray();
					for (Answer answer : question.getAnswers().traverseInOrder()) {
						JsonObject answerObject = new JsonObject();
						answerObject.addProperty("statement", answer.getStatement());
						answerObject.addProperty("flagIsCorrect", answer.getFlagIsCorrect());
						answerObject.addProperty("flagFiftyFifty", answer.getFlagFiftyFifty());

						answerArray.add(answerObject);
					}
					questionObject.add("answers", answerArray);
					questionArray.add(questionObject);
				}

				difficultyObject.add("questions", questionArray);
				difficultyArray.add(difficultyObject);
			}
		}
		return difficultyArray.toString();
	}
}