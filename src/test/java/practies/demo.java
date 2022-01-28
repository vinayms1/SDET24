package practies;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {

	@Test
	public void Program2() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement saleTabBar = driver.findElement(By.xpath("//span[contains(.,\"Sale\") and @class=\"topnav_itemname\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(saleTabBar).build().perform();
		driver.findElement(By.xpath("//span[contains(.,\"Fabric Sofas\")]")).click();
		driver.findElement(By.xpath("//a[contains(.,\"Close\") and @class=\"close-reveal-modal hide-mobile\"]")).click();
		driver.findElement(By.xpath("(//div[contains(.,\"Chelsea Adjustable Sectional Sofa\") and @class=\"name col-md-12\"])[1]")).click();
//		String parentId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		//title[contains(.,"Chelsea Adjustable Sectional Sofa (Grey) - Urban Ladder")]
		String ExpectedTitle="Chelsea Adjustable Sectional Sofa";
		for (String string : allWindowId) {
			driver.switchTo().window(string);
			String ActualTitle = driver.getTitle();
			if(ActualTitle.contains(ExpectedTitle)) {

				driver.findElement(By.xpath("//a[contains(.,\"Close\") and @class=\"close-reveal-modal hide-mobile\"]")).click();
		        WebElement addCartButton = driver.findElement(By.xpath("//button[@id=\"add-to-cart-button\" and @class=\"button full\"]"));
//		        int locationOfAddCart = addCartButton.getLocation().getY();
//		        JavascriptExecutor jse= (JavascriptExecutor)driver;
//		        jse.executeScript("window.scrollBy(0,"+locationOfAddCart+")");
//		        Thread.sleep(3000);
		        addCartButton.click();	
		        driver.findElement(By.xpath("(//button[@id=\"checkout-link\"])[1]")).click();
		        driver.findElement(By.xpath("//input[@id=\"order_email\"]")).sendKeys("vinay.ms@gmail.com");
		        driver.findElement(By.xpath("//input[@id=\"order_ship_address_attributes_zipcode\"]")).sendKeys("560013");
		        driver.findElement(By.xpath("//*[@id=\"order_ship_address_attributes_address1\"]")).sendKeys("vinay, mandya, krishnarajapet");
		        driver.findElement(By.xpath("//*[@id=\"order_ship_address_attributes_firstname\"]")).sendKeys("VINAY");
		        driver.findElement(By.xpath("//*[@id=\"order_ship_address_attributes_lastname\"]")).sendKeys("MS");
		        driver.findElement(By.xpath("//*[@id=\"order_ship_address_attributes_phone\"]")).sendKeys("9964648142");
		        driver.findElement(By.xpath("//*[@id=\"address-form-submit\"]")).click();
		        String FinalPrice = driver.findElement(By.xpath("//label[.=\"Total Payable Amount\"]/parent::li/descendant::span")).getText();
		        String ActualPrice = "72,374";
		        if(FinalPrice.contains(ActualPrice)) {
		        	driver.quit();
		        }
		        else {
		        	System.err.println("Price is not matching");
		        }
			}
		}
	}
}