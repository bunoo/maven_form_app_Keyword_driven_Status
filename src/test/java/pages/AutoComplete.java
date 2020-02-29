package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoComplete {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	/*Parameterized Constructor*/	
	public AutoComplete (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions (driver);
        PageFactory.initElements(driver,this);
    }
	
	/* Define all the web elements present on the HomePage using @FindBy annotation */
	//@FindBy (xpath = "//input[@type = 'text' and @class= 'form-control' and @id= 'postal_code' and @placeholder='Zip code']") WebElement zip_code;
	@FindBy (how = How.CSS, using = "input#postal_code[placeholder='Zip code']") @CacheLookup WebElement zip_code;
	
    //@FindBy (id = "autocomplete") @CacheLookup WebElement Address;
	@FindBy (how = How.CSS, using = "input.form-control[placeholder = 'Enter address']") @CacheLookup WebElement Address;
	
	/*Below are the implementations*/
	public void validate_autoComplete(String address_text, String zipCode) throws Exception {
		 
	       wait.until(ExpectedConditions.visibilityOf(Address)).click();
		   Address.clear();
		   Address.sendKeys(address_text);
		   Thread.sleep(4000); /* Explore a way to implement Explicit wait to validate the appearance of Suggestion Box */
		   
		   actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		   Thread.sleep(4000);

        String zip_code_act = zip_code.getAttribute("value").concat("a");
		   Assert.assertEquals(zip_code_act, zipCode, "the wrong value is rendered");
	      
}
	
}
