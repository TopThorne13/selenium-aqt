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

public class todaysDealTest extends Base{
	
	homepage homepage;
	private static final Logger logger = Logger.getLogger(todaysDealTest.class);
	
  @Test
  public void TodaysDeal_Test() throws IOException, InterruptedException {
	  getDriver().get(ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.INFO, "TodaysDeal_Test: Begin Test");
	  logger.info("TodaysDeal_Test: Begin Test");
	  
	  homepage = new homepage(getDriver());
	  getAction().moveToElement(homepage.todaysDealFirstItemEle()).perform();
	  getExplicitWait().until(ExpectedConditions.elementToBeClickable(homepage.todaysDealFirstItemEle()));
	  
	  extentTest().log(Status.PASS, "TodaysDeal_Test: PASSED");
	  logger.info("TodaysDeal_Test: Passed");
	  
	  extentTest().log(Status.INFO, "TodaysDeal_Test: Screenshot");
	  logger.info("TodaysDeal_Test: Screenshot");
	  
	  File source = homepage.todaysDealFirstItemEle().getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(source, new File(pathSS + "TodaysDealFirst_Status.png"));

	  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
			  pathSS + "TodaysDealFirst_Status.png",
			  "Todays Deal Screenshot").build());
  }

}
