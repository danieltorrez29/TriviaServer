package co.edu.uptc.model.persistence;

import com.google.gson.Gson;

import co.edu.uptc.net.Request;

/**
 * @author Daniel Torres
 * @Date 27/11/2022
 * @Description JsonRequest Class
 */

public class JsonRequestConstructor {

	/**
	 * 
	 * createJsonString String method that builds a json String from a Request
	 * object
	 * 
	 * @param request
	 * @return String
	 */

	public static String createJsonRequestString(Request request) {
		return new Gson().toJson(request);
	}

	/**
	 * 
	 * createRequestObject Request method that builds a Request object from a json
	 * String
	 * 
	 * @param json
	 * @return
	 */

	public static Request createRequestObject(String json) {
		return new Gson().fromJson(json, Request.class);
	}
}