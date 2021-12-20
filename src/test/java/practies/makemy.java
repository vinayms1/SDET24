package practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class makemy {
	@Test
	public void makemyTripTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement logo = driver.findElement(By.xpath("//a[@data-cy=\"mmtLogo\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(logo).click().build().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		WebElement src = driver.findElement(By.id("fromCity"));
		src.click();
		src.sendKeys("BOM");
		driver.findElement(By.xpath("//p[.=\"Mumbai, India\"]")).click();
		WebElement dst = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
		dst.click();
		dst.sendKeys("Chennai");
		driver.findElement(By.xpath("//p[.=\"Chennai, India\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),\"DEPARTURE\")]")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"Wed Nov 10 2021\"]")).click();
		driver.findElement(By.xpath("//a[.=\"Search\"]")).click();

		
	}

}
