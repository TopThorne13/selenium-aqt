package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.ReadProperties;
import library.Base;
import pages.homepage;

public class titleUrlAssert extends Base{
	
	homepage homepage;
	private static final Logger logger = Logger.getLogger(titleUrlAssert.class);
	
  @Test
  public void TitleAssert() throws IOException, InterruptedException {
	  getDriver().get(ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.INFO, "URL Assert: Begin Test");
	  logger.info("URL Assert: Begin Test");
	  
	  homepage = new homepage(getDriver());
	  
	  extentTest().log(Status.INFO, "URL Assert: Assert URL");
	  logger.info("URL Assert: Assert URL");
	  
	  Assert.assertEquals(homepage.getCurrentUrl(), ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.PASS, "URL Assert: URL Pass");
	  logger.info("URL Assert: URL Pass");
	  
	  
	  }
  
  @Test
  public void URLAssert() throws IOException, InterruptedException {
	  getDriver().get(ReadProperties.getConfig("applicationURL"));
	  
	  extentTest().log(Status.INFO, "Title Assert: Begin Test");
	  logger.info("Title Assert: Begin Test");
	  
	  homepage = new homepage(getDriver());
	  
	  extentTest().log(Status.INFO, "Title Assert: Assert Title");
	  logger.info("Title Assert: Assert Title");
	  
	  try {
	        Assert.assertEquals(homepage.getTitle(), "Amazon.in");
	        extentTest().log(Status.PASS, "Title Assert: Title Pass");
	        logger.info("Title Assert: Title Pass");
	    } catch (AssertionError e) {
	        extentTest().log(Status.FAIL, "Title Assert: Title Fail");
	        logger.error("Title Assert: Title Fail");
	        throw e;
	    }
  }
	  
}
