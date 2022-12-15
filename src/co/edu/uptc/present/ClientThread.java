package co.edu.uptc.present;

import java.net.Socket;

import co.edu.uptc.model.business.ServerSideGame;
import co.edu.uptc.model.persistence.JsonDifficultyTreeConstructor;
import co.edu.uptc.model.persistence.JsonRequestConstructor;
import co.edu.uptc.net.Connection;
import co.edu.uptc.net.Request;

/**
 * @author Daniel Torres
 * @Date 27/11/2022
 * @Description ClientThread Class
 */

public class ClientThread extends Thread {

	/**
	 * Attribute declaration
	 */

	private Connection connection;
	private ServerSideGame serverSideGame;
	private boolean runningProtocol;

	/**
	 * Constructor method
	 */

	public ClientThread(Socket clientSocket, ServerSideGame serverSideGame) {
		runningProtocol = true;
		connection = new Connection(clientSocket);
		this.serverSideGame = serverSideGame;
	}

	/**
	 * 
	 * protocol void method that is responsible for responding to customer requests
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
					case "Ingresar":
						if (this.serverSideGame.isUserRegistered(request.getUsername(), request.getPassword())) {
							request.setFlag(true);
							request.setLoggedInUser(serverSideGame.getUser(request.getUsername()));
						} else {
							request.setFlag(false);
						}
						connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
						break;

					case "Registrarse - Usuario":
						if (request.isFlag()) {
							serverSideGame.addUser(request.getEmail(), request.getUsername(), request.getPassword());
						} else {
							request.setFlag(serverSideGame.isUserExist(request.getUsername()));
							connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
						}
						break;

					case "Siguiente":
						serverSideGame.updateUserStats(request.getLoggedInUser());
						break;

					case "Podio":
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