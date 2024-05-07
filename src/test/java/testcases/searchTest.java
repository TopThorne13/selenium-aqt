package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.Base;
import library.ReadProperties;
import pages.homepage;
import pages.searchResults;

public class searchTest extends Base{
	
	homepage homepage;
	searchResults searchResults;
	private static final Logger logger = Logger.getLogger(searchTest.class);
	
	
	@Test
	  public void MinPriceCheck_Test() throws IOException, InterruptedException{
		  
		  getDriver().get(ReadProperties.getConfig("applicationURL"));
		  
		  extentTest().log(Status.INFO, "MinPriceCheck: Begin Test");
		  logger.info("MinPriceCheck: Begin Test");
		  
		  homepage = new homepage(getDriver());
		  searchResults = homepage.search(ReadProperties.getTestdata("searchItem1"));
		  
		  getExplicitWait().until(ExpectedConditions.visibilityOf(searchResults.firstResultEle()));
		  
		  searchResults.setMinPrice(Integer.parseInt(ReadProperties.getTestdata("price1")));
		  
		  try {
			    getExplicitWait().until(ExpectedConditions.visibilityOf(searchResults.firstResultEle()));
			    extentTest().log(Status.PASS, "FirstResultSS: PASSED");
			    logger.info("FirstResultSS: Passed");

			    getAction().scrollToElement(searchResults.firstResultEle());

			    Thread.sleep(2000);

			    extentTest().log(Status.INFO, "FirstResultSS: Screenshot");
			    logger.info("FirstResultSS: Screenshot");

			    File source = searchResults.firstResultEle().getScreenshotAs(OutputType.FILE);
			    FileHandler.copy(source, new File(pathSS + "FirstResultSSPass_Status.png"));

			    extentTest().info(MediaEntityBuilder.createScreenCaptureFromPath(
			            pathSS + "FirstResultSSPass_Status.png",
			            "Pass FirstResultSS").build());
			    
			} catch (TimeoutException e) {
			    extentTest().log(Status.FAIL, "FirstResultSS: Element not visible");
			    logger.error("FirstResultSS: Element not visible");
			    
			    File source = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			    
			    FileHandler.copy(source, new File(pathSS + "ResultsSSFullPage.png"));

			    extentTest().info(MediaEntityBuilder.createScreenCaptureFromPath(
			            pathSS + "ResultsSSFullPage.png",
			            "ResultsSSFullPage").build());
			}
	  }
	
  @Test
  public void FirstResultSS_Test() throws IOException, InterruptedException{
	  
	  getDriver().get(ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.INFO, "FirstResultSS: Begin Test");
	  logger.info("FirstResultSS: Begin Test");
	  
	  homepage = new homepage(getDriver());
	  searchResults = homepage.search(ReadProperties.getTestdata("searchItem2"));
	  
	  getExplicitWait().until(ExpectedConditions.visibilityOf(searchResults.firstResultEle()));
	  
	  extentTest().log(Status.PASS, "FirstResultSS: PASSED");
	  logger.info("FirstResultSS: Passed");
	  
	  getAction().scrollToElement(searchResults.firstResultEle());
	  
	  Thread.sleep(2000);
	  
	  extentTest().log(Status.INFO, "FirstResultSS: Screenshot");
	  logger.info("FirstResultSS: Screenshot");
	  
	  File source = searchResults.firstResultEle().getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(source, new File(pathSS + "FirstResultSSPass_Status.png"));

	  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
				pathSS + "FirstResultSSPass_Status.png",
				"Pass FirstResultSS").build());
  }
}
