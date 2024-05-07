package pages;

import library.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class homepage {
	
	WebDriver driver;
	
	public homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void deliveryLocation() {
		driver.findElement(By.id("nav-global-location-popover-link"));
	}
	
	public WebElement deliveryLocationEle() {
		return driver.findElement(By.id("nav-global-location-popover-link"));
	}
	
	public WebElement noDeliveryEle() {
		return driver.findElement(By.id("GLUXZipError"));
	}
	
	public WebElement pincodeDialog() {
		return driver.findElement(By.id("a-popover-1"));
	}
 	
	public void pinchange(String pincode) {
		WebElement delLoc= driver.findElement(By.id("nav-global-location-popover-link"));
		
		delLoc.click();
		
		WebElement pincodeBox = driver.findElement(By.id("GLUXZipUpdateInput"));
		
		pincodeBox.sendKeys(pincode);
		
		pincodeBox.sendKeys(Keys.ENTER);
	}
	
	public void todaysDealFirstItem() {
		driver.findElement(By.xpath("//*[@id=\"desktop-top\"]//li[1]"));
	}
	
	public WebElement todaysDealFirstItemEle() {
		return driver.findElement(By.xpath("//*[@id=\"desktop-top\"]//li[1]"));
	}
	
	public cart cart() {
		driver.findElement(By.id("nav-cart")).click();
		
		return new cart(driver);
	}
 	
	public searchResults search(String product) {
		
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        
        searchInput.sendKeys(product);
        
        searchInput.sendKeys(Keys.ENTER);
        
        return new searchResults(driver);
    }

}
