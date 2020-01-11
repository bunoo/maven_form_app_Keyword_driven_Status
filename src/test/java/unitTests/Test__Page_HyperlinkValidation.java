package unitTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HyperlinkValidation;

public class Test__Page_HyperlinkValidation {
	WebDriver driver;
	
	@Test
	public void check() {
		
		HyperlinkValidation hv_unit = new HyperlinkValidation(driver);
		hv_unit.click_autoComplete();
	}

}
