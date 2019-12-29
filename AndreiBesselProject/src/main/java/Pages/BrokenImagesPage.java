package Pages;

import java.io.IOException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resourses.verifyimageActive;

public class BrokenImagesPage {
	WebDriver driver;

	@FindBy(tagName = "img")
	List<WebElement> images;

	public BrokenImagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> images() {
		return images;
	}

	public int imagessize() {
		return images.size();
	}

	public int imageChecker() throws ClientProtocolException, IOException {
		int brokenimagescount = 0;
		for (WebElement img : this.images) {
			if (verifyimageActive.verifyimageActivem(img) != 0) {
				brokenimagescount++;
			}
		}
		return brokenimagescount;
	}
}
