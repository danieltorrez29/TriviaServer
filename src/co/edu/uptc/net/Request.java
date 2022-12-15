package co.edu.uptc.net;

import java.util.ArrayList;

import co.edu.uptc.model.business.User;

/**
 * @author Daniel Torres
 * @Date 27/11/2022
 * @Description Request Class
 */

public class Request {

	/**
	 * Attribute declaration
	 */

	private String questions;
	private boolean flag;
	private String actionCommand;
	private String email;
	private String username;
	private String password;
	private User loggedInUser;
	private ArrayList<User> topFiveUsers;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param serverSideGame
	 * @param clientSideGame
	 */

	public Request() {
		questions = "";
		flag = false;
		actionCommand = "";
		email = "";
		username = "";
		password = "";
		loggedInUser = null;
		topFiveUsers = null;
	}

	/**
	 * 
	 * Constructor method
	 * 
	 * @param questions
	 */

	public Request(String questions) {
		this.questions = questions;
		flag = false;
		actionCommand = "";
		email = "";
		username = "";
		password = "";
		loggedInUser = null;
		topFiveUsers = null;
	}

	/**
	 * getQuestions method
	 * 
	 * @return questions
	 */

	public String getQuestions() {
		return questions;
	}

	/**
	 * setQuestions method
	 * 
	 * @param questions
	 */

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	/**
	 * isFlag method
	 * 
	 * @return flag
	 */

	public boolean isFlag() {
		return flag;
	}

	/**
	 * setFlag method
	 * 
	 * @param flag
	 */

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * getActionCommand method
	 * 
	 * @return actionCommand
	 */

	public String getActionCommand() {
		return actionCommand;
	}

	/**
	 * setActionCommand method
	 * 
	 * @param actionCommand
	 */

	public void setActionCommand(String actionCommand) {
		this.actionCommand = actionCommand;
	}

	/**
	 * getEmail method
	 * 
	 * @return email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * setEmail method
	 * 
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getUsername method
	 * 
	 * @return username
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * setUsername method
	 * 
	 * @param username
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getPassword method
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * setPassword method
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getLoggedInUser method
	 * 
	 * @return loggedInUser
	 */

	public User getLoggedInUser() {
		return loggedInUser;
	}

	/**
	 * setLoggedInUser method
	 * 
	 * @param loggedInUser
	 */

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	/**
	 * getTopFiveUsers method
	 * 
	 * @return topFiveUsers
	 */

	public ArrayList<User> getTopFiveUsers() {
		return topFiveUsers;
	}

	/**
	 * setTopFiveUsers method
	 * 
	 * @param topFiveUsers
	 */

	public void setTopFiveUsers(ArrayList<User> topFiveUsers) {
		this.topFiveUsers = topFiveUsers;
	}

	/**
	 * toString overwrite method
	 */

	@Override
	public String toString() {
		return "Request [questions=" + questions + ", flag=" + flag + ", actionCommand=" + actionCommand + ", email="
				+ email + ", username=" + username + ", password=" + password + ", loggedInUser=" + loggedInUser
				+ ", topFiveUsers=" + topFiveUsers + "]";
	}
}