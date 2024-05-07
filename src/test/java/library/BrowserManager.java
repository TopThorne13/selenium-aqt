package library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

	public static WebDriver doBrowserSetup(String browserName) {

		WebDriver driver = null;
		if (browserName.equalsIgnoreCase(ReadProperties.getConfig("browserName"))) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("-headed"); //manage for headless or headed mode

			driver = new ChromeDriver(chromeOptions);

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
					Integer.parseInt(ReadProperties.getConfig("globalWait"))));
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
			
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
					Integer.parseInt(ReadProperties.getConfig("globalWait"))));
			
		}
		
		else if(browserName.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("marionette", false); 
	        FirefoxOptions options = new FirefoxOptions(); 
	        options.merge(capabilities);
			
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
					Integer.parseInt(ReadProperties.getConfig("globalWait"))));
			
		}
		
		return driver;
	}
}