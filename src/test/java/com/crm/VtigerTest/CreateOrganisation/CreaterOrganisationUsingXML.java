package com.crm.VtigerTest.CreateOrganisation;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vtiger.genericLibrary.ExcelUtile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreaterOrganisationUsingXML {
	@Test
	public void createOganisationTest(XmlTest xml) throws Throwable, IOException, Throwable {
		Random ran=new Random();
		int ranWeb = ran.nextInt(100);
		
		ExcelUtile eLib=new ExcelUtile();
		String url = xml.getParameter("url1");
		String username = xml.getParameter("username");
		String password = xml.getParameter("password");
		String browser = xml.getParameter("browxser");
		String data = eLib.getExcelValue("Sheet1", 0, 0)+"_"+ranWeb;
		
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
