package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckboxValidation extends HomePage {

	
	/*Parameterized Constructor*/	
	public CheckboxValidation (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }
	
	/* Define web elements using @FindBy annotation as WebElement */
	@FindBy(xpath = "//a[@class='btn btn-lg' and @href='/checkbox']") WebElement checkbox;
	@FindBy (xpath = "//input[@type='checkbox' and @id='checkbox-1' and @aria-label='checkbox' and @value='checkbox-1']") WebElement chkbox1;
	@FindBy (id = "checkbox-2") WebElement chkbox2;
	@FindBy (id = "checkbox-3") WebElement chkbox3;
	
	
	/*Below are the implementations*/
	public void click_Checkbox() {
		    
		 wait.until(ExpectedConditions.visibilityOf(checkbox)).click();
	}
	
	public void validate_display_text_Checkboxes () {
		   
		   boolean act_contain_chkboxes = driver.getPageSource().contains("Checkboxes");
		   boolean exp_contain_chkboxes = driver.getPageSource().contains("Checkboxes");
		   Assert.assertEquals(act_contain_chkboxes, exp_contain_chkboxes, "the text called Checkboxes is missing");
	}
	
	 public void validate_checkbox1 () {
		 
		   wait.until(ExpectedConditions.visibilityOf(chkbox1)); 
		   
		   /* LEARNING BITE : If you have to run this method in isolation, then this step is not required. But when you trigger the whole
		    * test suite, it is required to check the visibility of element, else it fails. */
		   
		   boolean a = chkbox1.isDisplayed();
		   if (a == true) {
			   chkbox1.click();
			   boolean isChecked1 = chkbox1.isSelected();
			   Assert.assertEquals(isChecked1, true, "user is not able to check the checkbox1");
			   }
		   else if (a == false) {
			   System.out.print("Checbox1 is not visible");
		   }
	     }
	 
	 public void validate_checkbox2 () {
			 
		    wait.until(ExpectedConditions.visibilityOf(chkbox2));
			boolean a = chkbox2.isDisplayed();
			if (a == true) {
				   chkbox2.click();
				   boolean isChecked2 = chkbox2.isSelected();
				   Assert.assertEquals(isChecked2, true, "user is not able to check the checkbox2");
				   }
			   else if (a == false) {
				   System.out.print("Checbox2 is not visible");
			   }
		 }
	 
	 public void validate_checkbox3 () {
		     
		    wait.until(ExpectedConditions.visibilityOf(chkbox3));
		    boolean a = chkbox3.isDisplayed();
				   if (a == true) {
					   chkbox3.click();
					   boolean isChecked3 = chkbox3.isSelected();
					   Assert.assertEquals(isChecked3, true, "user is not able to check the checkbox3");
					   }
				   else if (a == false) {
					   System.out.print("Checbox3 is not visible");
			  }
	     }
	
}
