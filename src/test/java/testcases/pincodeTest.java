package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.ReadProperties;
import library.Base;
import pages.homepage;

public class pincodeTest extends Base{
	
	homepage homepage;
	private static final Logger logger = Logger.getLogger(pincodeTest.class);
	
  @Test
  public void PIN_Fail() throws IOException, InterruptedException {
	  getDriver().get(ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.INFO, "PIN_Fail: Begin Test");
	  logger.info("PIN_Fail: Begin Test");
	  
	  homepage = new homepage(getDriver());
	  homepage.pinchange(ReadProperties.getTestdata("pincode1"));
	  
	  getExplicitWait().until(ExpectedConditions.visibilityOf(homepage.noDeliveryEle()));
	  
	  extentTest().log(Status.FAIL, "PIN_Fail: FAILED");
	  logger.error("PIN_Fail: Failed");
	  
	  extentTest().log(Status.INFO, "PIN_Fail: Screenshot");
	  logger.info("PIN_Fail: Screenshot");
	  
	  File source = homepage.pincodeDialog().getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(source, new File(pathSS + "PincodeFail_Status.png"));

	  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
				pathSS + "PincodeFail_Status.png",
				"Fail PIN").build());
	  
  }
  
  @Test
  public void PIN_Pass() throws IOException, InterruptedException {
	  getDriver().get(ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.INFO, "PIN_Pass: Begin Test");
	  logger.info("PIN_Pass: Begin Test");
	  
	  homepage = new homepage(getDriver());
	  homepage.pinchange(ReadProperties.getTestdata("pincode2"));
	  
	  Thread.sleep(5000);
	  
	  getExplicitWait().until(ExpectedConditions.visibilityOf(homepage.deliveryLocationEle()));
	  
	  extentTest().log(Status.PASS, "PIN_Pass: PASSED");
	  logger.info("PIN_Pass: Passed");
	  
	  extentTest().log(Status.INFO, "PIN_Pass: Screenshot");
	  logger.info("PIN_Pass: Screenshot");
	  
	  File source = homepage.deliveryLocationEle().getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(source, new File(pathSS + "PincodePass_Status.png"));

	  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
				pathSS + "PincodePass_Status.png",
				"Pass PIN").build());
	  
  }
  
}
