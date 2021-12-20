package practies;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.ExcelUtile;
import com.vtiger.genericLibrary.FileUtiles;
import com.vtiger.genericLibrary.WebDriverUtility;
import com.vtiger.genericLibrary.javaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigmnent {
	@Test
	public void table() throws Throwable {
		
		ExcelUtile eLib = new ExcelUtile();
		FileUtiles fLib = new FileUtiles();
		javaUtility jLib = new javaUtility();
		String ranWeb = jLib.randomInt();
		WebDriverUtility wLib = new WebDriverUtility();
		String url = fLib.getvalues("url");
		String username = fLib.getvalues("username");
		String password = fLib.getvalues("password");
		String browser = fLib.getvalues("browser");
		String organisationName = eLib.getExcelValue("Sheet1", 0, 0) + "_" +ranWeb;
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		wLib.implicitWait(driver);
		wLib.maximize(driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//*[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//*[@name=\"accountname\"]")).sendKeys(organisationName);
			
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("hdrLink")).click();

		List<WebElement> allOrgName = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]/a"));
		for(int i=1;i<allOrgName.size();i++) {
			String org = allOrgName.get(i).getText();
			
			if(org.contains(organisationName)) {
				driver.findElement(By.xpath("//a[.='"+organisationName+"']/../../td[8]/a[2]")).click();
			}
		}
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
	}
}