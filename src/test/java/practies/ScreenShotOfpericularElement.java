package practies;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.xmlgraphics.image.rendered.BufferedImageCachableRed;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Point;

public class ScreenShotOfpericularElement {

	public static void main(String[] args) throws Throwable {
		//set the location of chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");
      
        WebElement logo = driver.findElement(By.xpath("//img[@title=\"Flipkart\"]"));
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullScreen = ImageIO.read(screenshot);
        Point location = logo.getLocation();
        int Height = logo.getSize().getHeight();
        int Width = logo.getSize().getWidth();
      
        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(),Width, Height);
        ImageIO.write(logoImage, "png", screenshot);
        FileUtils.copyFile(screenshot, new File(".\\projectScreenshots\\particularElementScreenshot.PNG"));
        driver.quit();
    }
	

}
