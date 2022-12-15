package co.edu.uptc.model.persistence;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;

import co.edu.uptc.model.business.User;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description JsonUserTreeWriter Class
 */

public class JsonUserTreeWriter {

	/**
	 * 
	 * writeUsers void method that writes a json file from a User list
	 * 
	 * @param users
	 */

	public static void writeUsers(ArrayList<User> users) {
		Gson gson = new Gson();
		try (OutputStream outputStream = new FileOutputStream("resources/data/users.json");
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
			gson.toJson(users, bufferedWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}