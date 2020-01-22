package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.LandinPage;
import driver.base;

public class ABbuttonTest extends base {
	LandinPage objLandingPage;

	@BeforeTest(groups = { "TestsOnly" })
	public void driver() throws IOException {
		base base = new base();
		driver=base.initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().fullscreen();

	}

	@Test(priority = 0, groups = { "TestsOnly" })
	public void test() {
		objLandingPage = new LandinPage(driver);
		objLandingPage.clickonABTesting();
		driver.navigate().back();
	}

	@AfterTest(groups = { "TestsOnly" })
	public void driverEnd() throws InterruptedException {
		driver.quit();
	}

}
