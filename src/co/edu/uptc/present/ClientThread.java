package co.edu.uptc.present;

import co.edu.uptc.model.business.ServerSideGame;
import co.edu.uptc.model.persistence.JsonDifficultyTreeConstructor;
import co.edu.uptc.model.persistence.JsonRequestConstructor;
import co.edu.uptc.net.Connection;
import co.edu.uptc.net.Request;
import java.net.Socket;

/**
 * 
 * ClientThread class
 * 
 * @author Daniel Torres
 */

public class ClientThread extends Thread {

	/**
	 * Connection
	 */

	private Connection connection;

	/**
	 * ServerSideGame
	 */

	private ServerSideGame serverSideGame;

	/**
	 * Running protocol flag
	 */

	private boolean runningProtocol;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param clientSocket
	 * @param serverSideGame
	 */

	public ClientThread(Socket clientSocket, ServerSideGame serverSideGame) {
		runningProtocol = true;
		connection = new Connection(clientSocket);
		this.serverSideGame = serverSideGame;
	}

	/**
	 * 
	 * protocol void method that is responsible for responding to client requests
	 * and sending responses
	 */

	private void protocol() {
		connection.writeUTF(JsonRequestConstructor.createJsonRequestString(
				new Request(JsonDifficultyTreeConstructor.createJsonString(serverSideGame.getRandomQuestionTree()))));
		Request request = new Request();
		try {
			while (runningProtocol) {
				if (connection.inputStreamAvailable() > 0) {
					request = JsonRequestConstructor.createRequestObject(connection.readUTF());
					switch (request.getActionCommand()) {
					case "Sign In":
						if (this.serverSideGame.isUserRegistered(request.getUsername(), request.getPassword())) {
							request.setFlag(true);
							request.setLoggedInUser(serverSideGame.getUser(request.getUsername()));
						} else {
							request.setFlag(false);
						}
						connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
						break;

					case "Sign In - User":
						if (request.isFlag()) {
							serverSideGame.addUser(request.getEmail(), request.getUsername(), request.getPassword());
						} else {
							request.setFlag(serverSideGame.isUserExist(request.getUsername()));
							connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
						}
						break;

					case "Create Account - User":
						// Account creation flow requested by the client.
						// First request: flag = false -> the server responds with flag = true if the user exists.
						// Second request: flag = true and email/username/password are sent -> the server registers the user.	
						if (request.isFlag()) {
							serverSideGame.addUser(request.getEmail(), request.getUsername(), request.getPassword());
						} else {
							request.setFlag(serverSideGame.isUserExist(request.getUsername()));
							connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
						}
						break;

					case "Next":
						serverSideGame.updateUserStats(request.getLoggedInUser());
						break;

					case "Podium":
						request.setTopFiveUsers(serverSideGame.getTopFive());
						connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
						break;

					default:
						break;
					}
				}
			}
		} catch (Exception e) {
			runningProtocol = false;
		}
	}

	/**
	 * run overwrite method
	 */

	@Override
	public void run() {
		protocol();
		connection.close();
	}
}