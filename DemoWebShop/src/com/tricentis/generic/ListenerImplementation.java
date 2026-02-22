package com.tricentis.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getName();
		Reporter.log(methodname+" has be passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getName();
		Reporter.log("Failure");
		Object testclass = result.getInstance();
		driver=((BaseClass)testclass).getDriver();
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+methodname+timestamp+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {  }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getName();
		Reporter.log(methodname+" has been skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}