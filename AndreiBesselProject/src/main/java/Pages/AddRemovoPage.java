package Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovoPage {
	WebDriver driver;
	@FindBy(xpath = "//button[@onclick='addElement()']")
	WebElement addEments;
	@FindBy(xpath = "//button[@onclick='deleteElement()']")
	List<WebElement> removeElement;

	public AddRemovoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void addEmentsClick() {
		addEments.click();
	}
	public void removeEmentsClick() {
		removeElement.get(0).click();
	}
	public void add100Ithems() {
		for (int i = 0; i < 100; i++) {
			this.addEmentsClick();
		}
	}
	public void ifvisibleDelete() {
		while (removeElement.size() > 0) {
			this.removeEmentsClick();
		}
	}
}
