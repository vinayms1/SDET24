package practies;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cleratrip {

	@Test
	public void makemyTripTest() {

		Date da = new Date();
		String date = da.toString();
		String[] today = date.split(" ");
		String day = today[0];
		String month = today[1];
		String actualday = today[2];
		String year = today[5];
		String concatDate = day + " " + month + " " + actualday + " " + year;
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@placeholder=\"Any worldwide city or airport\"])[1]")).sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");
		driver.findElement(By.xpath("//p[.='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
		driver.findElement(By.xpath("(//input[@placeholder=\"Any worldwide city or airport\"])[2]")).sendKeys("Chennai, IN - Chennai Airport (MAA)");
		driver.findElement(By.xpath("//p[.='Chennai, IN - Chennai Airport (MAA)']")).click();
		driver.findElement(By.xpath("//button[@style=\"min-width: 185px;\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label='"+concatDate+"']")).click();
		driver.findElement(By.xpath("//button[.=\"Search flights\"]")).click();
	}
}