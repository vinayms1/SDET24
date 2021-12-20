package com.vtiger.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLibrary.WebDriverUtility;

public class Creating_New_Organization {
	@FindBy(name="accountname")
	private WebElement organizationTextBox;
	
	@FindBy(name="industry")
	private WebElement accountTypeListBox;
	
	@FindBy(name="accounttype")
	private WebElement selectindustryListBox;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;;
	

	public Creating_New_Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrganizationTextBox() {
		return organizationTextBox;
	}


	public WebElement getAccountTypeListBox() {
		return accountTypeListBox;
	}


	public WebElement getSelectindustryListBox() {
		return selectindustryListBox;
	}
	
	

	public WebElement getSaveButton() {
		return saveButton;
	}


	public void organizationName(String Data) {
		organizationTextBox.sendKeys(Data);
		
	}
	public void savebutton() {
		saveButton.click();
	}
	public void selectIndustry(String INDUSTRYNAME) {
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.Select(accountTypeListBox, INDUSTRYNAME);
	}
	public void accountType(String ACCOUNTTYPE) {
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.Select(selectindustryListBox, ACCOUNTTYPE );

	}
	
	
	
}
