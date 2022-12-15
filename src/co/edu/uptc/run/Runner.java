package co.edu.uptc.run;

import co.edu.uptc.present.ServerPresenter;

/**
 * @author Daniel Torres
 * @Date 27/11/2022
 * @Description Runner Class
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