package library;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public static WebDriver get() {
		return threadLocalDriver.get();
	}

	public static void set(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	public static void remove() {
		threadLocalDriver.remove();
	}

}
