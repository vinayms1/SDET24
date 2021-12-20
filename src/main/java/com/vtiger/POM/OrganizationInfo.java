package com.vtiger.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	@FindBy(className="dvHeaderText")
	private WebElement OrganizationTitle;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement IndustrySelect;
	
	@FindBy(id="mouseArea_Type")
	private WebElement accountTypeSelect;
	
	
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationTitle() {
		return OrganizationTitle;
	}
	
	public WebElement getIndustrySelect() {
		return IndustrySelect;
	}

	public WebElement getAccountTypeSelect() {
		return accountTypeSelect;
	}

	public void titleOfTheOrganization(String ORGNAME) {
		String text = OrganizationTitle.getText();
		if(text.contains(ORGNAME)) {
			System.out.println(ORGNAME+" ORGANIZATION IS CREATED==> TEST CASE IS PASS");
		}
		else {
			System.out.println(ORGNAME+" ORGANIZATION IS NOT CREATED==> TEST CASE IS FAIL");
		}	
	}
	
	public void titleOfIndustryAndAccountType(String INDUSTRYNAME, String ACCOUNTTYPE) {
		String text1 = IndustrySelect.getText();
		String text2 = accountTypeSelect.getText();
		if(text1.contains(INDUSTRYNAME)&&text2.contains(ACCOUNTTYPE)) {
			System.out.println(" INDUSTRYNAME AND ACCOUNTTYPE IS MATCHED==> TEST CASE IS PASS");
		}
		else {
			System.out.println(" INDUSTRYNAME AND ACCOUNTTYPE IS NOT MATCHED==> TEST CASE IS FAIL");
	}
	
	}
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	


