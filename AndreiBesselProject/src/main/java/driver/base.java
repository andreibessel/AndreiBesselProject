package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;
	public  WebDriver initializeDriver() throws IOException
	{
	
		Properties prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\driver\\data.properties");
		prop.load(fis);
	
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\driver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
		options.addArguments("--headless");
		
			WebDriver driver=new ChromeDriver(options);
				
	      	this.driver=driver;
			
		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();			
		this.driver=driver;
		}
		else if(browserName.contains("Grid"))
		{
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.MAC);
			WebDriver driver =new RemoteWebDriver(new URL("http://192.168.1.16:4444/wd/hub"),dc);
			this.driver=driver;
		}
		
		
		
		
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	return driver;
		
	}
	
	public void getscreenshot(String result) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(("user.dir")+"\\AndreiBesselProject\\screenshot\\"+result+"screenshot.png"));
	
	}

}
