package practies;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.tagName("link"));
		for (WebElement webElement : allLinks) {
			String urllinks=webElement.getAttribute("href");
			
			Thread.sleep(3000);
		
			HttpURLConnection httpUrlConnect = (HttpURLConnection) new URL(urllinks).openConnection();
			httpUrlConnect.connect();
			if(httpUrlConnect.getResponseCode()>=400) {
				System.out.println(urllinks+" ==> THE LINK WAS BROKEN");
			}
			
			
		}
		driver.close();
	}

}
