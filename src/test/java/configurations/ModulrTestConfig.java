package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModulrTestConfig {

	public String ModulrPortalUrl="https://secure-sandbox.modulrfinance.com/";
	

	public WebDriver initialiseDriver() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\Configurations\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	return driver;
	}
}
