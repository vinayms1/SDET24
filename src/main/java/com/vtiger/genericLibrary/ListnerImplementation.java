package com.vtiger.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;


public class ListnerImplementation implements  ITestListener {
	ExtentReports report;
	ExtentTest test;
	javaUtility jlib= new javaUtility();
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
			}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" IS PASS");
	
	}

	public void onTestFailure(ITestResult result) {
		
		Object obj = result.getInstance();
		WebDriver driver=null;
		
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath=".//screenshot//"+result.getMethod().getMethodName()+jlib.randomInt()+".PNG";
		File dest=new File(screenshotPath);
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step5:log for failure methods
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" IS SKIPPED");
		test.log(Status.SKIP, result.getThrowable());	
	}
	@Override
	public void onStart(ITestContext context) {
		//Step1: Configuration
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./Reports/extentreport"+jlib.randomInt()+".html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Vtiger Automation Report");
		htmlReporter.config().setReportName("Execution Report");
		//step2: attaching report and system info
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Url", "http://localhost:8888/");
		report.setSystemInfo("Platform", "Windows10");
		report.setSystemInfo("Repoter Name", "Nithesh");
	}

	@Override
	public void onFinish(ITestContext context) {
		//step7: flush the report
		report.flush();
		
	}
}
