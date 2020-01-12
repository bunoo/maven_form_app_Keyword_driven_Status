package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class TitleValidation extends HomePage {
	
	/* Define a parameterized Constructor*/
	public TitleValidation (WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
	}
	
	
	/* Define methods */
	public void validate_title() {
		   String vt = driver.getTitle();
		   Assert.assertEquals(vt, "Formy", "YOU ARE AT WRONG PAGE");
	   }
	
}
