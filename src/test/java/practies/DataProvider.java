package practies;

import org.testng.annotations.Test;

public class DataProvider {
	
	
	@Test(dataProvider = "getData")
	public void bookTicket(String src,String dst) {
		System.out.println("ticket was booked from "+ src +" to "+ dst);
	}
	@org.testng.annotations.DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[5][2];
		obj[0][0]="bengaluru";
		obj[0][1]="mysore";
		
		obj[1][0]="bengaluru";
		obj[1][1]="mandya";
		
		obj[2][0]="bengaluru";
		obj[2][1]="hubli";
		
		obj[3][0]="bengaluru";
		obj[3][1]="belagavi";
		
		obj[4][0]="bengaluru";
		obj[4][1]="dharwad";
		return obj;	
	}
}
