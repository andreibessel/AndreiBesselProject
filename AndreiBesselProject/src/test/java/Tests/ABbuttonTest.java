package Tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AddRemovoPage;
import Pages.LandinPage;

import driver.base;


public class ABbuttonTest extends base {
	
	
	
	LandinPage objLandingPage;


	public ABbuttonTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest(groups = { "TestsOnly"})
	public void driver() throws IOException {
		base base=new base();
		base.initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().fullscreen();

		
		
	}
	
	@Test(priority=0,groups = { "TestsOnly"})
	public void test() {
		//click on first button
		objLandingPage=new LandinPage(driver);
		
		objLandingPage.clickonABTesting();
		
		driver.navigate().back();
		
		
		
		
	}
	@AfterTest(groups = { "TestsOnly"})
	public void driverEnd() throws InterruptedException {
		driver.quit();
	}

}
