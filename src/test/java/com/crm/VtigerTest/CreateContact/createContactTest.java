package com.crm.VtigerTest.CreateContact;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.ExcelUtile;
import com.vtiger.genericLibrary.FileUtiles;
import com.vtiger.genericLibrary.WebDriverUtility;
import com.vtiger.genericLibrary.javaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createContactTest {
	@Test
	public void CreateContactTest() throws Throwable {
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
		String FirstName = eLib.getExcelValue("Sheet2", 0, 0) + "_" +ranWeb;
		String LastName = eLib.getExcelValue("Sheet2", 0, 1) + "_" +ranWeb;

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
		
		WebElement indweb = driver.findElement(By.name("industry"));
		wLib.Select(indweb, "Education");

		WebElement typeweb = driver.findElement(By.name("accounttype"));
		wLib.Select(typeweb, "Analyst");    
		
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if (text.contains(organisationName)) {
			System.out.println("Organisation is created==> TestCase is Pass..!");
		}
		else {
			System.out.println("Organisation is not created==> TestCase is Fail..!");
		}
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Contacts"))));
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		String parentid = driver.getWindowHandle();
		Set<String> allwid = driver.getWindowHandles();
		Iterator<String> itr = allwid.iterator();
 
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String title = driver.getTitle();
			if (title.contains("Accounts&action")) {
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(organisationName);
		driver.findElement(By.xpath("//input[@class=\"crmbutton small create\"]")).click();
		driver.findElement(By.xpath("//a[.='" + organisationName + "']")).click();
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		String title = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (title.contains(LastName)) {
			System.out.println("Contact is succesfully created==>TestCase is Pass..!");
		} else {
			System.out.println("Contact is not created==>TestCase is Fail");
		}
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
