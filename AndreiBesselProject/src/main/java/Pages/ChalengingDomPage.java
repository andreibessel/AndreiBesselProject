package Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ChalengingDomPage {

	WebDriver driver;

	@FindBy(xpath = "//td")
	List<WebElement> alltable;

	public ChalengingDomPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}

	public void TableSearch(String searchIthem) {
		for (WebElement content : alltable) {
			if (content.getText().equalsIgnoreCase(searchIthem)) {
				System.out.println("Ithem-" + searchIthem + "-Found");
			}
		}

	}
}
