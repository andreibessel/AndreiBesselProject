package Pages;


import java.util.List;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasicAuthPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/p")
	WebElement massage;

	public BasicAuthPage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, this);
		
		
	}
	

	public void sendUsernamePassword(String username,String password){
		
		driver.get("http://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		
		
	}
	
	
	
public void massageReadCorrect() {
		
	String masasagepage=massage.getText();
	String expectedmassage="Congratulations! You must have the proper credentials.";
		
	Assert.assertTrue(masasagepage.equalsIgnoreCase(expectedmassage));
		
	}

	
	
}
