package com.vtiger.genericLibrary;

import java.util.Random;
/**
 * 
 * @author Vinay
 *
 */


public class javaUtility {
	/**
	 * 
	 * @return the random value
	 */
	public String randomInt() {
		Random r= new Random();
		int random = r.nextInt(1000);
		return ""+random;
		
	}
	

}
 