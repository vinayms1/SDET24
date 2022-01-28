package practies;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.vtiger.genericLibrary.ListnerImplementation.class)
public class Practies  {
	public WebDriver driver=null;
	@Test(priority = 0)
	public void ecommerceTest() {
		
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		WebElement accountAndList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions act = new Actions(driver);
		act.moveToElement(accountAndList).perform();
		driver.findElement(By.xpath("//span[.=\"Your Orders\"]")).click();
		driver.navigate().back();
		Assert.fail();
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		int PriceLocation = driver.findElement(By.xpath("//span[.=\"₹5,000 - ₹10,000\"]")).getLocation().getY();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + PriceLocation + ")");
		driver.findElement(By.xpath("//span[.=\"₹5,000 - ₹10,000\"]")).click();
		driver.navigate().back();
		int PriceLocation1 = driver.findElement(By.xpath("//span[.=\"Over ₹20,000\"]")).getLocation().getY();
		jse.executeScript("window.scrollBy(0," + PriceLocation1 + ")");
		driver.findElement(By.xpath("//span[.=\"Over ₹20,000\"]")).click();
		driver.findElement(By.xpath("//span[.=\"Apple iPhone 11 (256GB) - (Product) RED\"]")).click();
		String parentID = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
//		String ExpectedTitle="New-Apple-iPhone-11-256GB";
		Iterator<String> itr = all.iterator();
		String main = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);
		driver.close();
		driver.switchTo().window(parentID);
	}
//	@Test
//	public void aaa() {
//		System.out.println("this is skipped");
//		
//	}
//	@Test
//	public void bbb() {
//	System.out.println("sdadasdsadsdsa");
//	}
}
