package co.edu.uptc.model.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description ProfilePicPath Class
 */

public enum ProfilePicPath {

	/**
	 * Objects
	 */

	CHAMELEON("resources/images/chameleon.png"), DINOSAUR("resources/images/dinosaur.png"),
	ELEPHANT("resources/images/elephant.png"), FOX("resources/images/fox.png"), KOALA("resources/images/koala.png"),
	LION("resources/images/lion.png"), SNAKE("resources/images/snake.png"), TOUCAN("resources/images/toucan.png");

	/**
	 * Constants
	 */

	private static final List<ProfilePicPath> PROFILE_PATH_VALUES = Collections
			.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = PROFILE_PATH_VALUES.size();
	private static final Random RANDOM = new Random();

	/**
	 * Attribute declaration
	 */

	private String path;

	/**
	 * Constructor method
	 * 
	 * @param path
	 */

	private ProfilePicPath(String path) {
		this.path = path;
	}

	/**
	 * getPath method
	 * 
	 * @return path
	 */

	private String getPath() {
		return path;
	}

	/**
	 * 
	 * getRandomProfilePicPath String method
	 * 
	 * @return random profile pic path
	 */

	public static String getRandomProfilePicPath() {
		return PROFILE_PATH_VALUES.get(RANDOM.nextInt(SIZE)).getPath();
	}
}