package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cart {
	
	WebDriver driver;
	
	public cart(WebDriver driver) {
		this.driver = driver;
	}
	
	public void delete() {
		driver.findElement(By.xpath("(//*[@id=\"sc-active-cart\"]//input)[6]"));
	}
	
	public WebElement deleteEle() {
		return driver.findElement(By.xpath("(//*[@id=\"sc-active-cart\"]//input)[6]"));
	}
	
	public WebElement buyBox() {
		return driver.findElement(By.id("sc-buy-box"));
	}
	
	public WebElement freeDeliveryEle() {
		return driver.findElement(By.xpath("//*[contains(text(), \"Your order is eligible for FREE Delivery\")]"));
	}
	
	public WebElement noFreeDeliveryEle() {
		return driver.findElement(By.xpath("(//*[contains(text(), \"Add items worth\")])"));
	}
	
	public WebElement emptyCartEle() {
		return driver.findElement(By.id("sc-empty-cart"));
	}

}


//(//*[contains(text(), "Add items worth")])

//*[contains(text(), "Your order is eligible for FREE Delivery")]

//(//*[@id="sc-active-cart"]//input)[6]