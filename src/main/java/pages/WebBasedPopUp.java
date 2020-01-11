package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebBasedPopUp extends HomePage {

	/*Parameterized Constructor*/	
	public WebBasedPopUp (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        actions = new Actions (driver);
        PageFactory.initElements(driver,this);
    }
	
	/* Define web elements using @FindBy annotation */
	@FindBy (xpath = "//button[@type='button' and @class='btn btn-primary' and @id='alert-button' and @onclick='myFunction()']") WebElement openAlert;	
	
	/*Below are the implementations*/
	public void clickOpenAlert() {
		wait.until(ExpectedConditions.visibilityOf(openAlert)).click();
	}
	
	public void closeSimpleAlert() {
		
		boolean b = driver.switchTo().alert() != null;
		Alert alert = driver.switchTo().alert();
		
		if (b == true) {
			alert.accept();
		}
		
	}
}
