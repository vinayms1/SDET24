  package com.crm.RMGYANTRATest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_project {
	String projectname = "RMGY5";
	String createdby = "AJAY";

	@Test(priority = 1)
	public void testCreateProject() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Projects\")]")).click();
		driver.findElement(By.xpath("//span[contains(text(),\"Create Project\")]")).click();
		driver.findElement(By.xpath("//input[@name=\"projectName\"]")).sendKeys(projectname);
		driver.findElement(By.xpath("//input[@name=\"createdBy\"]")).sendKeys(createdby);
		WebElement select = driver.findElement(By.xpath("(//select[@name=\"status\"])[2]"));
		Select s = new Select(select);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.close();
	}
	@Test(priority = 2)
	public void connectDataBase() throws Throwable {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project where project_name ='RMGY5';");
		while (result.next()) {
			System.out.println(result.getString(4));

			if (result.getString(4).equals(projectname)) {
				System.out.println("project is created");

			} else {
				System.out.println("project is not created");
			}
		}
	}
}
