package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.Base;
import library.ReadProperties;
import pages.homepage;
import pages.searchResults;
import pages.cart;

public class cartItemsTest extends Base{
	
	homepage homepage;
	cart cart;
	searchResults searchResults;
	private static final Logger logger = Logger.getLogger(cartItemsTest.class);
	
	
	@Test
	  public void EmptyCart_Test() throws IOException, InterruptedException{
		  
		  getDriver().get(ReadProperties.getConfig("applicationURL"));
		  
		  extentTest().log(Status.INFO, "EmptyCart: Begin Test");
		  logger.info("EmptyCart: Begin Test");
		  
		  homepage = new homepage(getDriver());
		  cart = homepage.cart();
		  
		  getExplicitWait().until(ExpectedConditions.visibilityOf(cart.emptyCartEle()));
		  
		  extentTest().log(Status.PASS, "EmptyCart: True");
		  logger.info("EmptyCart: True");
		  
		  extentTest().log(Status.INFO, "EmptyCart: Take Screenshot");
		  logger.info("EmptyCart: Take Screenshot");
		  
		  File source = cart.emptyCartEle().getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source, new File(pathSS + "EmptyCart_Status.png"));

		  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
					pathSS + "EmptyCart_Status.png",
					"Empty Cart").build());
	}
	
	
	@Test
	  public void FreeDelivery_Test() throws IOException, InterruptedException{
		  
		  getDriver().get(ReadProperties.getConfig("applicationURL"));
		  
		  extentTest().log(Status.INFO, "FreeDelivery: Begin Test");
		  logger.info("FreeDelivery: Begin Test");
		  
		  homepage = new homepage(getDriver());
		  
		  searchResults = homepage.search(ReadProperties.getTestdata("searchItem2"));
		  
		  searchResults.firstResultAddToCart();
		  
		  getExplicitWait().until(ExpectedConditions.visibilityOf(searchResults.itemAddedEle()));
		  
		  Thread.sleep(3000);
		  
		  cart = searchResults.cart();
		  
		  getExplicitWait().until(ExpectedConditions.visibilityOf(cart.freeDeliveryEle()));
		  
		  extentTest().log(Status.PASS, "FreeDelivery: True");
		  logger.info("FreeDelivery: True");
		  
		  extentTest().log(Status.INFO, "FreeDelivery: Take Screenshot");
		  logger.info("FreeDelivery: Take Screenshot");
		  
		  File source = cart.buyBox().getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source, new File(pathSS + "FreeDelivery_Status.png"));

		  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
					pathSS + "FreeDelivery_Status.png",
					"Free Delivery").build());
	}
	
	@Test
	  public void NoFreeDelivery_Test() throws IOException, InterruptedException{
		  
		  getDriver().get(ReadProperties.getConfig("applicationURL"));
		  
		  extentTest().log(Status.INFO, "NoFreeDelivery: Begin Test");
		  logger.info("NoFreeDelivery: Begin Test");
		  
		  homepage = new homepage(getDriver());
		  
		  searchResults = homepage.search(ReadProperties.getTestdata("searchItem3"));
		  
		  searchResults.firstResultAddToCart();
		  
		  getExplicitWait().until(ExpectedConditions.visibilityOf(searchResults.itemAddedEle()));
		  
		  Thread.sleep(3000);
		  
		  cart = searchResults.cart();
		  
		  getExplicitWait().until(ExpectedConditions.visibilityOf(cart.noFreeDeliveryEle()));
		  
		  extentTest().log(Status.PASS, "NoFreeDelivery: True");
		  logger.info("NoFreeDelivery: True");
		  
		  extentTest().log(Status.INFO, "NoFreeDelivery: Take Screenshot");
		  logger.info("NoFreeDelivery: Take Screenshot");
		  
		  File source = cart.buyBox().getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source, new File(pathSS + "NoFreeDelivery_Status.png"));

		  extentTest().info(MediaEntityBuilder. createScreenCaptureFromPath(
					pathSS + "NoFreeDelivery_Status.png",
					"No Free Delivery").build());
	}
	
	
}