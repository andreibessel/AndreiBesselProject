package Pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckboxesPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkBoxes;

	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);

	}

	public List<WebElement> checkBoxes() {
		return checkBoxes;

	}

	public void whatCheckBoxIsChecked() {
		int selectedcheckboxes = 0;
		int notselectedcheckbox = 0;
		for (WebElement box : this.checkBoxes) {
			if (box.isSelected()) {
				selectedcheckboxes++;
			}
			notselectedcheckbox = checkBoxes.size() - selectedcheckboxes;
		}
		System.out.println("The Number Of Selected Check Boxes Is-" + selectedcheckboxes);
		System.out.println("The Number Of Not Selected Check Boxes Is-" + notselectedcheckbox);
	}

	public void randomClickingOnBoxes() {
		Random rand = new Random();
		for (WebElement box : this.checkBoxes) {
			for (int i = 0; i < rand.nextInt(100); i++) {
				box.click();
			}

		}

	}

}
