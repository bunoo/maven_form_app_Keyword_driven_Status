package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TitleValidation {
	WebDriver driver; //Why do I need to declare driver here when it is already declared in the "BaseClass.java" and the same is imported in this class??
	
	public void validate_title() {
		
		   System.out.println("ok1");
		   String vt = driver.getTitle();
		   System.out.println("ok2");
		   Assert.assertEquals(vt, "Formy", "YOU ARE AT WRONG PAGE");
		   System.out.println("ok3");
	   }
	
}
