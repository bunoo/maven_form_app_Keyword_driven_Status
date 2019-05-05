package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class HyperlinkValidation {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	/*Parameterized Constructor*/	
	public HyperlinkValidation (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions (driver);
        PageFactory.initElements(driver,this);
    }

	
	/* Define web elements using @FindBy annotation as WebElement */
	/*---- I have used How class as well  ---- */
	/*---- Use @CacheLookup for some elements. It will store the . It stores the WebElement in the cache m/y, so the system does not look onto the web page.
	Hence it increases the performance in the long run.  ----*/
	
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='/dropdown']") @CacheLookup WebElement dropdown;
	@FindBy (id = "autocomplete") @CacheLookup WebElement Address;
	@FindBy (how = How.ID, using = "navbarDropdownMenuLink") @CacheLookup WebElement Components;
	@FindBy (how = How.XPATH, using = "//a[@class='btn btn-lg' and @href='/autocomplete']") @CacheLookup WebElement btnAutocomplete;
	//@FindBy (how = How.CSS, using = "button#dropdownMenuButton") @CacheLookup WebElement drop_down_btn;
	@FindBy (css = "button#dropdownMenuButton") WebElement drop_down_btn;
	
	
	/*LEARNING BITE : FOR -VE TESTING, YOU CAN PUT A DOT IN THE OBJECTS LOCATED ABOVE*/
	
	/*Below are the implementations*/
	public void click_dropDown() {
		
		wait.until(ExpectedConditions.visibilityOf(Components)).click();  
		wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
	}
	 
	public boolean validate_dropDownButton() { 
		   
		   wait.until(ExpectedConditions.visibilityOf(drop_down_btn));
           boolean x = drop_down_btn.isDisplayed();
		   return x;
	}
	
	public void click_autoComplete() {
		
		wait.until(ExpectedConditions.visibilityOf(btnAutocomplete)).click();
		}
	
	public void rightClick_autoComplete() {
		
		actions.contextClick(btnAutocomplete).perform();
	}
	
	public void validate_autoComplete() {
		 
		   wait.until(ExpectedConditions.visibilityOf(Address)).click();
		   Address.clear();
		   Address.sendKeys("1555 Park Blvd, Palo Alto, CA"); 
	   }
	
}