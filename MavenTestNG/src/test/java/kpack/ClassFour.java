package kpack;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassFour {
	@BeforeTest
	public void mood() {
		System.out.println("this is before test");
	}
	@Test
	void clsFour() {
		System.out.println("class Four is executed");
	}
}
