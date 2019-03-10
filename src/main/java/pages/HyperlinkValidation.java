package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HyperlinkValidation {

	WebDriver driver;
	
	public void click_dropDown() {
		
		   WebDriverWait wait=new WebDriverWait(driver, 5); //Explicit wait
		   WebElement Components = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbarDropdownMenuLink")));
		   Components.click();
		   WebElement dropdown = driver.findElement(By.xpath("//a[@class='dropdown-item' and @href='/dropdown']"));				   
		   dropdown.click(); //Later on explore the way how to validate the click op
	 }
	 
	public boolean validate_dropDownButton() { 
		
		   WebDriverWait wait=new WebDriverWait(driver, 5); //Explicit wait
		   //BELOW SCENARIO IS FAILING INTENTIONALLY. IF YOU WANT TO GET IT PASSES, REMOVE THE ".." FROM THE OBJECT LOCATOR
		   WebElement drop_down_menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#dropdownMenuButton..")));
           boolean x = drop_down_menu.isDisplayed();
		   return x;
	}
	
	public void click_autoComplete() {
		   
		   WebDriverWait wait=new WebDriverWait(driver, 5); //Explicit wait
		   WebElement btnAutocomplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/autocomplete']")));
		   btnAutocomplete.click();}
	   
	   public void validate_autoComplete() {
		 
		   WebDriverWait wait=new WebDriverWait(driver, 5); //Explicit wait
		   //BELOW SCENARIO IS FAILING INTENTIONALLY. IF YOU WANT TO GET IT PASSES, REMOVE THE ".." FROM THE OBJECT LOCATOR
		   WebElement Address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
		   Address.click();
		   Address.clear();
		   Address.sendKeys("1555 Park Blvd, Palo Alto, CA"); 
		   //TRY TO EXPLORE A WAY TO CHOOSE A VALUE FROM THE DROPDOWN, PROBABLY BY SLOW TYPING, THIS CAN BE SORTED OUT
	   }
	
}
