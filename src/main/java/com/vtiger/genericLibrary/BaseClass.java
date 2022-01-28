package com.vtiger.genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.POM.HomePage;
import com.vtiger.POM.LoginPage;

public class BaseClass {
	public  WebDriver driver;
	public FileUtiles fLib= new FileUtiles(); 
	public javaUtility jLib= new javaUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public ExcelUtile eLib= new ExcelUtile();
	DataBaseConnection dbLib=new DataBaseConnection();
	public static WebDriver staticDriver;
	

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws Throwable {
		Reporter.log("DataBase is Connected", true);
		dbLib.getConnection();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		Reporter.log("DataBase is Close", true);
		dbLib.databaseClose();
	}
	@Parameters(value="BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		
		String BROWSER = fLib.getvalues("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		staticDriver=driver;
		driver.get(fLib.getvalues("url"));
		wLib.maximize(driver);
		wLib.implicitWait(driver);
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		driver.close();
	}
	
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		String USERNAME = fLib.getvalues("username");
		String PASSWORD = fLib.getvalues("password");
		LoginPage lLib = new LoginPage(driver);
		lLib.login(USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		HomePage hLib= new HomePage(driver);
		hLib.signout();
	}
	

}
