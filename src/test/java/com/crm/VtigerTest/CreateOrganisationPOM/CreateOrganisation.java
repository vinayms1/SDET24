package com.crm.VtigerTest.CreateOrganisationPOM;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.vtiger.POM.Creating_New_Organization;
import com.vtiger.POM.HomePage;
import com.vtiger.POM.OrganizationInfo;
import com.vtiger.POM.OrganizationPage;
import com.vtiger.genericLibrary.BaseClass;

public class CreateOrganisation extends BaseClass {

	@Test(groups = "smokeTest")
	public void CreateOrganizationTest() throws Throwable {

		String ORGNAME = eLib.getExcelValue("Sheet1", 0, 0) + jLib.randomInt();

		HomePage hpg = new HomePage(driver);
		OrganizationPage opg = new OrganizationPage(driver);
		Creating_New_Organization cnopg = new Creating_New_Organization(driver);
		OrganizationInfo orginfopg = new OrganizationInfo(driver);

		hpg.OrganizationLink();
		opg.createorganizationTest();
		cnopg.organizationName(ORGNAME);
		cnopg.savebutton();
		orginfopg.titleOfTheOrganization(ORGNAME);
	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationTestWithIndustry() throws Throwable {

		String ORGNAME = eLib.getExcelValue("Sheet1", 0, 0) + jLib.randomInt();
		String INDUSTRYNAME = eLib.getExcelValue("Sheet1", 0, 2);
		String ACCOUNTTYPE = eLib.getExcelValue("Sheet1", 0, 3);

		HomePage hpg = new HomePage(driver);
		OrganizationPage opg = new OrganizationPage(driver);
		Creating_New_Organization cnopg = new Creating_New_Organization(driver);
		OrganizationInfo orginfopg = new OrganizationInfo(driver);

		hpg.OrganizationLink();
		opg.createorganizationTest();
		cnopg.organizationName(ORGNAME);
		cnopg.selectIndustry(INDUSTRYNAME);
		cnopg.accountType(ACCOUNTTYPE);
		cnopg.savebutton();
		orginfopg.titleOfTheOrganization(ORGNAME);
		orginfopg.titleOfIndustryAndAccountType(INDUSTRYNAME, ACCOUNTTYPE);
	}

	@Test(retryAnalyzer = com.vtiger.genericLibrary.retryAnalyser.class)
	public void sumne() {
		Reporter.log("retry analyzer", true);
		Assert.fail();
	}

}
