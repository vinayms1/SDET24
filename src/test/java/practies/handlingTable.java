package practies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.FileUtiles;
import com.vtiger.genericLibrary.WebDriverUtility;

public class handlingTable {
	@Test
	public void table() throws Throwable {
		
		FileUtiles fLib = new FileUtiles();
		
		
		WebDriverUtility wLib = new WebDriverUtility();
		String url = fLib.getvalues("url");
		String username = fLib.getvalues("username");
		String password = fLib.getvalues("password");
		String browser = fLib.getvalues("browser");
		
		
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
		
		//click all the check box
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]/input"));
	for(int i=1;i<allCheckBox.size();i++) {
		allCheckBox.get(i).click();
	}
		//uncheck the last check box
	allCheckBox.get(allCheckBox.size()-1).click();
	
	//click the 6th row
	driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[6]/td[1]/input")).click();

	List<WebElement> allOrgName = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]/a"));
	for(int i=1;i<allOrgName.size();i++) {
		String text = allOrgName.get(i).getText();
		System.out.println(text);
	}

}
}