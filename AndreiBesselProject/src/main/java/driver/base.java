package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {
	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		String browserName = "chrome";
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions(); 
			if (browserName.contains("headless"))
				chromeOptions.addArguments("--headless");
			WebDriver driver = new ChromeDriver(chromeOptions);
			this.driver = driver;
		} else if (browserName.contains("Grid")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.MAC);
			WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.16:4444/wd/hub"), dc);
			this.driver = driver;
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}

	

}
