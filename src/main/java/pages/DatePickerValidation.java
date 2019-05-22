package pages;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerValidation {

	WebDriver driver;
	WebDriverWait wait;
	
	/*Parameterized Constructor*/	
	public DatePickerValidation (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }

	/* Define web elements using @FindBy annotation as WebElement. */
	/* ACTION ITEM - Later on implement @CacheLookup annotations*/
	@FindBy (how = How.ID, using = "navbarDropdownMenuLink") @CacheLookup WebElement Components;
	@FindBy (how = How.XPATH, using = "//a[@class = \"dropdown-item\" and @href=\"/datepicker\"]") @CacheLookup WebElement datePicker;
	@FindBy (xpath = "//input[@type='text' and @class='form-control' and @id='datepicker']") @CacheLookup WebElement dateFieldText;
	
	
	/*Below are the implementations*/
	public void click_DatePicker() {
		
		Components.click();
		datePicker.click();
		}
	
	public void click_DatePicker_text_field() {
		
		wait.until(ExpectedConditions.visibilityOf(dateFieldText));
		dateFieldText.click();
		
	}
	
	public void click_T_plus_7(){

		Calendar calendar = new GregorianCalendar();
		int currentDate = calendar.get(Calendar.DAY_OF_MONTH);
		int sevendays = currentDate + 7;
		System.out.println("T+7 is "+sevendays); //Working fine
}
	
	
}
