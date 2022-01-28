package practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sikuliDemo {
	@Test
	public void fileUpload() throws InterruptedException, Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand_Login_Register&gclid=Cj0KCQiA_8OPBhDtARIsAKQu0gYtaVJ6nJYlMSsUSM1wlWx2ZSUqUMYnQc4-MPYO4ZUhegX_BdSMpwwaApoiEALw_wcB&gclsrc=aw.ds");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.=\"Upload Resume\"]")).click();

		Pattern textField= new Pattern("C:\\Users\\Vinay\\Pictures\\Camera Roll\\textField.PNG");
		Pattern openButton= new Pattern("C:\\Users\\Vinay\\Pictures\\Camera Roll\\textField.PNG");
		Screen screen = new Screen();
		screen.click(textField);
		screen.type("C:\\Users\\Vinay\\Downloads\\selenium webdriver.pdf");
		screen.click(openButton);
		
		Thread.sleep(5000);
		driver.close();
	}
}
