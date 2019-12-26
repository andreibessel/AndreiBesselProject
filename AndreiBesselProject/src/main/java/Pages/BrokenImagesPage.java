package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BrokenImagesPage {
	
	WebDriver driver;
	
	@FindBy(tagName="img")
	List<WebElement> images;
	

	public BrokenImagesPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	

public List<WebElement> images() {
		
	return images;
		
	}

	
	
}
