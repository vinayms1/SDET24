package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	@Test

	public void sampleAutomation() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("vinay@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("vinay");

		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).sendKeys("iphone");

		driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]")).click();
		driver.findElement(By.xpath("//*[@class=\"caption\"]//a[text()='iPhone']")).click();
		driver.findElement(By.id("input-quantity")).clear();
		driver.findElement(By.id("input-quantity")).sendKeys("2");
		driver.findElement(By.id("button-cart")).click();
		driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();
		WebElement b = driver.findElement(By.xpath("//input[@name=\"quantity[33920]\"]"));
		b.clear();
		b.sendKeys("2");
		driver.findElement(By.xpath("//i[@class=\"fa fa-refresh\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]")).click();

	}

}
