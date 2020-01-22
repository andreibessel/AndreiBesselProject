package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.ChalengingDomPage;
import Pages.LandinPage;
import driver.base;

public class ChallengingDomTest extends base {
	LandinPage objLandingPage;
	ChalengingDomPage objChalengingDomPage;

	@BeforeTest
	public void driver() throws IOException {
		base base = new base();
		driver=base.initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().fullscreen();

	}

	@Test(priority = 0, groups = { "TestsOnly" })
	public void test() {
		// click on first button
		objLandingPage = new LandinPage(driver);
		objLandingPage.ChallengingDOMbtnClick();
		objChalengingDomPage = new ChalengingDomPage(driver);
		objChalengingDomPage.TableSearch("Consequuntur8");
		driver.navigate().back();

	}

	@AfterTest
	public void driverEnd() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
