package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AddRemovoPage;
import Pages.CheckboxesPage;
import Pages.LandinPage;
import driver.base;

public class CheckboxesTest extends base {
	LandinPage objLandingPage;
	CheckboxesPage objCheckboxesPage;

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
		objLandingPage.CheckboxesbtnClick();
		objCheckboxesPage = new CheckboxesPage(driver);
		objCheckboxesPage.whatCheckBoxIsChecked();
		System.out.println("Random Clicking");
		objCheckboxesPage.randomClickingOnBoxes();
		objCheckboxesPage.whatCheckBoxIsChecked();
		driver.navigate().back();

	}

	@AfterTest
	public void driverEnd() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
