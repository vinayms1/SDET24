package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAndAfterClass {

	@AfterClass
	public void closure() {
		System.out.println("the method is closed");
	}
	
	@BeforeClass
	public void setUp() {
		System.out.println("page is setuped");
	}

	@Test(priority = 1)
	public void testRegistration() {
		System.out.println("registration pahe will be displayed");

	}

	@Test(priority = 2)
	public void testLogin() {
		System.out.println("you have successfully logged in");
	}

	@Test(priority = 3)
	public void testHomepage() {
		System.out.println("you have entered into home page");
	}

}
