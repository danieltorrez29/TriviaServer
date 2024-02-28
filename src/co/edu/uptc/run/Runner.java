package co.edu.uptc.run;

import co.edu.uptc.present.ServerPresenter;

/**
 * 
 * Runner class
 * 
 * @author Daniel Torres
 */

public class Runner {

	/**
	 * main void method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		new ServerPresenter().listen();
	}
}