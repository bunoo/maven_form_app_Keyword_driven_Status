package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage{

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	/* Define web elements present on the HomePage using @FindBy annotation */

	@FindBy (xpath = "//a[@class='btn btn-lg' and @href='/form']") WebElement Form;
	@FindBy (xpath = "//a[@class= 'btn btn-lg' and @href = '/switch-window']") WebElement switchWindow;
	
	/*Below are the implementations*/
	public void clickSwitchWindow() {
		wait.until(ExpectedConditions.visibilityOf(switchWindow)).click();
	}
	
	/*The below piece of code is written to test the <<export of this project to another project>>.
	 * Essentially I have made this project a <<Library Project>> or we can say <<core/master>> project*/
    public void testExport() {
		System.out.println("hi");
	}
	
}