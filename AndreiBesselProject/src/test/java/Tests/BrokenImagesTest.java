package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.BrokenImagesPage;
import Pages.LandinPage;
import driver.base;

public class BrokenImagesTest extends base {
	LandinPage objLandingPage;
	BrokenImagesPage objBrokenImagesPage;

	@BeforeTest
	public void driver() throws IOException {
		base base = new base();
		base.initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().fullscreen();
	}

	@Test(priority = 0, groups = { "TestsOnly" })
	public void test() throws ClientProtocolException, IOException {
		int brokenimages = 0;
		objLandingPage = new LandinPage(driver);
		objLandingPage.BrokenimagenbtnClick();
		objBrokenImagesPage = new BrokenImagesPage(driver);
		int imgescount = objBrokenImagesPage.imagessize();
		System.out.println("Total Number Of Images IS- " + imgescount);
		brokenimages = objBrokenImagesPage.imageChecker();
		System.out.println("Number Of Broken Images Is" + brokenimages);
		driver.navigate().back();
	}

	@AfterTest
	public void driverEnd() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
