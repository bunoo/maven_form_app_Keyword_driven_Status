package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TitleValidation {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	public TitleValidation (WebDriver driver) {
		this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions (driver);
        PageFactory.initElements(driver,this);
	}
	/* Define methods */
	public void validate_title() {
		   String vt = driver.getTitle();
		   Assert.assertEquals(vt, "Formy", "YOU ARE AT WRONG PAGE");
	   }
	
}

