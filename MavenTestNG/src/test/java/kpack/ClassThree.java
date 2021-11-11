package kpack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ClassThree {
	
	@AfterTest
	
	public void math() {
		System.out.println("this is after test");
	}
	
	
	@Test
	void clsThree() {
		
		System.out.println("class Three is executed");
	}

}
