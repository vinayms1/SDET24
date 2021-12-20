package com.crm.VtigerTest.CreateOrganisation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.genericLibrary.ExcelUtile;
import com.vtiger.genericLibrary.FileUtiles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganisationTest {

	public static void main(String[] args) throws Throwable {
		FileUtiles fLib= new FileUtiles();
		ExcelUtile eLib=new ExcelUtile();
		String url = fLib.getvalues("url");
		String username = fLib.getvalues("username");
		String password = fLib.getvalues("password");
		String browser = fLib.getvalues("browser");	
		String data = eLib.getExcelValue("Sheet1", 0, 0);
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = null;
		if(browser.equals("chrome")) {
		driver = new ChromeDriver();}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//*[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//*[@name=\"accountname\"]")).sendKeys(data);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains(data)) {
			System.out.println("organisation is created");
			driver.close();
		}
		
		
		
	}

}
