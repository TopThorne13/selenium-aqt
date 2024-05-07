package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.Base;

public class searchResults {
	
	WebDriver driver;
	
	public searchResults(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setMinPrice(int price) {
		WebElement el = driver.findElement(By.id("low-price"));
		el.sendKeys(Integer.toString(price));
		el.sendKeys(Keys.ENTER);
	}
	
	public void setMaxPrice(int price) {
		WebElement el = driver.findElement(By.id("high-price"));
		el.sendKeys(Integer.toString(price));
		el.sendKeys(Keys.ENTER);
	}
	
	public void firstResultAddToCart() {
		driver.findElement(By.xpath("(//button[contains(text(), \"Add to cart\")])[1]")).click();
	}
	
	public WebElement cartCountEle() {
		return driver.findElement(By.id("nav-cart-count"));
	}
	
	public WebElement itemAddedEle() {
		return driver.findElement(By.xpath("(//*[contains(text(), \"Item Added\")])"));
	}
	
	public WebElement firstResultEle() {
		return driver.findElement(By.xpath("(//*[@class=\"rush-component\"])[4]"));
	}
	
	public WebElement cartEle() {
		return driver.findElement(By.id("nav-cart"));
	}
	
	public cart cart() {
		driver.findElement(By.id("nav-cart")).click();
		
		return new cart(driver);
	}

}
