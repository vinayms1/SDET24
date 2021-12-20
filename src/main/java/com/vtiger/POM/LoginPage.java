package com.vtiger.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernametextbox;
	
	@FindBy(name="user_password")
	private WebElement passwordtextbox;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	public WebElement getPasswordtextbox() {
		return passwordtextbox;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getUsernametextbox() {
		return usernametextbox;
	}
	
	public void login(String USERNAME, String PASSWORD) {
		
		usernametextbox.sendKeys(USERNAME);
		passwordtextbox.sendKeys(PASSWORD);
		loginbutton.click();
	}
	
	

}
