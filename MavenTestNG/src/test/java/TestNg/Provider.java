package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider {
	
	
	@Test(dataProvider ="getData" )
	public void loginTest(String username, String pwd) {
		System.out.println("the user is successfully logged in using user name: "+username+" and password is "+pwd);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0]="vinay";
		data[0][1]="12345";
		
		data[1][0]="ajay";
		data[1][1]="45465";
		
		data[2][0]="vikram";
		data[2][1]="97898";
		
		
		return data;
	}
}
