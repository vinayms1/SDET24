package practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class demo {
	
		@Test
		public void Program2() throws Throwable {

			WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("search")).sendKeys("study table");
		driver.findElement(By.id("search_button")).click();
		driver.findElement(By.xpath("(//a[@class='product-img'])[4]")).click();
		WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Unnamed\"]"));
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.moveToElement(logo).click().build().perform();

}
}