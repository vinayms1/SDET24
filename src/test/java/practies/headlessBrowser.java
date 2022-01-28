package practies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessBrowser {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.google.com/");
		System.out.println("Title is "+driver.getTitle());
	}

} 
