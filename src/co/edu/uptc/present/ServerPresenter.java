package co.edu.uptc.present;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import co.edu.uptc.model.business.ServerSideGame;

/**
 * 
 * ServerPresenter class
 * 
 * @author Daniel Torres
 */

public class ServerPresenter {

	/**
	 * ServerSocket
	 */

	private ServerSocket serverSocket;

	/**
	 * ServerSideGame
	 */

	private ServerSideGame serverSideGame;

	/**
	 * Constructor method
	 */

	public ServerPresenter() {
		initServerSocket();
		serverSideGame = new ServerSideGame();
	}

	/**
	 * 
	 * initServerSocket void method
	 */

	private void initServerSocket() {
		try (FileInputStream fileInputStream = new FileInputStream("resources/properties/config.properties");
				BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
			Properties properties = new Properties();
			properties.load(bufferedInputStream);
			serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty("PORT")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * listen void method
	 */

	public void listen() {
		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				ClientThread clientThread = new ClientThread(clientSocket, serverSideGame);
				clientThread.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}