package TestNg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethod1
{

	@BeforeMethod
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
