package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LandinPage {

	WebDriver driver;

	@FindBy(linkText = "A/B Testing")
	WebElement ABtesting;
	@FindBy(linkText = "Add/Remove Elements")
	WebElement addRemove;
	@FindBy(linkText = "Basic Auth")
	WebElement BasicAuth;
	@FindBy(linkText = "Broken Images")
	WebElement Brokenimagenbtn;
	@FindBy(linkText = "Challenging DOM")
	WebElement ChallengingDOM;
	@FindBy(linkText = "Checkboxes")
	WebElement Checkboxesbtn;

	public LandinPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);

	}

	public void clickonABTesting() {
		ABtesting.click();
	}

	public void addRemoveClick() {
		addRemove.click();
	}

	public void BasicAuthClick() {
		BasicAuth.click();
	}

	public void BrokenimagenbtnClick() {
		Brokenimagenbtn.click();
	}

	public void ChallengingDOMbtnClick() {
		ChallengingDOM.click();
	}

	public void CheckboxesbtnClick() {
		Checkboxesbtn.click();
	}

}
