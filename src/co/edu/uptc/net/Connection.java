package co.edu.uptc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * Connection class
 * 
 * @author Daniel Torres
 */

public class Connection {

	/**
	 * Client socket
	 */

	private Socket client;

	/**
	 * Input data stream
	 */

	private DataInputStream input;

	/**
	 * Output data stream
	 */

	private DataOutputStream output;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param socket
	 */

	public Connection(Socket socket) {
		try {
			client = socket;
			input = new DataInputStream(client.getInputStream());
			output = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * readUTF String method
	 * 
	 * @return String
	 */

	public String readUTF() {
		try {
			return input.readUTF();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * writeUTF void method
	 * 
	 * @param json
	 */

	public void writeUTF(String json) {
		try {
			output.writeUTF(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * close void method
	 */

	public void close() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * inputStreamAvailable int method that determines channel's bytes amount
	 * available to read
	 * 
	 * @return int
	 */

	public int inputStreamAvailable() {
		int bytes = -1;
		try {
			bytes = input.available();
		} catch (Exception e) {
			bytes = -1;
		}
		return bytes;
	}
}