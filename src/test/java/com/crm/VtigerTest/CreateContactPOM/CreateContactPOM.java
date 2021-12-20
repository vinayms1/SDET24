package com.crm.VtigerTest.CreateContactPOM;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.POM.Contact_info_page;
import com.vtiger.POM.ContactsPage;
import com.vtiger.POM.Creating_New_Contact;
import com.vtiger.POM.Creating_New_Organization;
import com.vtiger.POM.HomePage;
import com.vtiger.POM.OrganizationInfo;
import com.vtiger.POM.OrganizationPage;
import com.vtiger.genericLibrary.BaseClass;

public class CreateContactPOM extends BaseClass {
	

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

		String FIRSTNAME = eLib.getExcelValue("Sheet2", 0, 0) + "_" + jLib.randomInt();
		String LASTNAME = eLib.getExcelValue("Sheet2", 0, 1);

		HomePage hpg = new HomePage(driver);
		Creating_New_Organization cnopg = new Creating_New_Organization(driver);
		ContactsPage cpg = new ContactsPage(driver);
		Creating_New_Contact cncpg = new Creating_New_Contact(driver);
		Contact_info_page cipg = new Contact_info_page(driver);

		hpg.getContactsLink().click();
		cpg.getCreateContact().click();

		cncpg.getFirstNameTextBox().sendKeys(FIRSTNAME);
		cncpg.getLastNameTextBox().sendKeys(LASTNAME);

		cnopg.savebutton();
		Thread.sleep(3000);
		if (cipg.getFirstName().getText().contains(FIRSTNAME) && cipg.getLastName().getText().contains(LASTNAME)) {
			Reporter.log("Create Contact is Succesfull==> TestCase is Pass", true);
			
		} else {
			Reporter.log("Create Contact is not Succesfull==> TestCase is Fail", true);
			
		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithIndustryPomTest() throws Throwable, Throwable, Throwable {

		String ORGNAME = eLib.getExcelValue("Sheet1", 0, 0) + "_" + jLib.randomInt();
		String INDUSTRYNAME = eLib.getExcelValue("Sheet1", 0, 2);
		String ACCOUNTTYPE = eLib.getExcelValue("Sheet1", 0, 3);
		String FIRSTNAME = eLib.getExcelValue("Sheet2", 0, 0) + "_" +jLib.randomInt();
		String LASTNAME = eLib.getExcelValue("Sheet2", 0, 1);

		HomePage hpg = new HomePage(driver);
		OrganizationPage orgpg = new OrganizationPage(driver);
		Creating_New_Organization cnopg = new Creating_New_Organization(driver);
		OrganizationInfo oginfo = new OrganizationInfo(driver);
		ContactsPage cpg = new ContactsPage(driver);
		Creating_New_Contact cncpg = new Creating_New_Contact(driver);
		Contact_info_page cipg = new Contact_info_page(driver);

		hpg.OrganizationLink();
		orgpg.createorganizationTest();
		cnopg.organizationName(ORGNAME);
		cnopg.selectIndustry(INDUSTRYNAME);
		cnopg.accountType(ACCOUNTTYPE);
		cnopg.savebutton();
		oginfo.titleOfIndustryAndAccountType(INDUSTRYNAME, ACCOUNTTYPE);

		hpg.getContactsLink().click();
		cpg.getCreateContact().click();

		cncpg.getFirstNameTextBox().sendKeys(FIRSTNAME);
		cncpg.getLastNameTextBox().sendKeys(LASTNAME);
		cncpg.getOrganizationLookUpPage().click();

		String parentid = driver.getWindowHandle();
		wLib.switchToWindow(driver,"Accounts&action");

		orgpg.getSearchTextBox().sendKeys(ORGNAME);
		orgpg.getSearchNowbutton().click();
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();

		driver.switchTo().window(parentid);
		cnopg.savebutton();
		Thread.sleep(3000);
		if (cipg.getFirstName().getText().contains(FIRSTNAME) && cipg.getLastName().getText().contains(LASTNAME)
				&& cipg.getOrganizationName().getText().contains(ORGNAME)) {
			Reporter.log("Create Contact is Succesfull==> TestCase is Pass", true);
		} else {
			Reporter.log("Create Contact is not Succesfull==> TestCase is Fail", true);
		}
		
	}

}
