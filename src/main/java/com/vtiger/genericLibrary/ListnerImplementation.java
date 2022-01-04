package com.vtiger.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	public ExtentHtmlReporter htmlReport;
	public ExtentReports reports;
	public ExtentTest test;
	public void onTestStart(ITestResult result) {
			}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" IS PASS");
	
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		Object obj = result.getInstance();
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+methodName+".PNG");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		
			try {
				test.addScreenCaptureFromPath(dst.getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" IS SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onStart(ITestContext context) {
		// htmlReport is to specify the path of the folder
				htmlReport=new ExtentHtmlReporter("./Reports/extent.html");
				htmlReport.config().setEncoding("UTF-8");
				htmlReport.config().setDocumentTitle("HTML REPORT");
				htmlReport.config().setReportName("Detailed Report");
				htmlReport.config().setTheme(Theme.DARK);
				
				
				// this is for mentioning the specification
				reports= new ExtentReports();
				reports.setSystemInfo("browser", "chrome");
				reports.setSystemInfo("Environment", "windows-10");
				reports.setSystemInfo("JDK", "11");
				reports.attachReporter(htmlReport);

		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}
	

}
