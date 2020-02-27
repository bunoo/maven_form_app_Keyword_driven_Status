package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.*;


/*public class ButtonColorValidation extends HomePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	Parameterized Constructor	
	public ButtonColorValidation (WebDriver driver) { //Error: // Error: Implicit super constructor HomePage() is undefined. Must explicitly invoke another constructor
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }*/
	
 public class ButtonColorValidation{
	
	 WebDriver driver;
	 WebDriverWait wait;
	 Actions actions;
	
	 public ButtonColorValidation (WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, 5);
	        PageFactory.initElements(driver,this);
	    }
	 
	/* Define web elements using @FindBy annotation as WebElement */
	
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-lg btn-primary']") @CacheLookup WebElement prButton;
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-lg btn-primary']") @CacheLookup WebElement PRIMARYbtnColor;
	
	
	/*Below are the implementations*/
	
	   public void validate_buttonColor()   {
		   
		   wait.until(ExpectedConditions.visibilityOf(prButton)).click();
		   /*ACTION ITEM - PROBABLY AT THIS STEP, I NEED TO PUT IN SOME WAIT TIME SO THAT AFTER CLICKING CONTENTS SHOULD GET RENDERED*/
		   boolean z = prButton.isDisplayed();
		   
		   if (z==true) {
		   /*----Get color by using "getCssValue(color)"----*/
			   
		   String color_of_pr_btn_Actual = PRIMARYbtnColor.getCssValue("color");
		   String color_of_pr_btn_Expected = "rgba(255, 255, 255, 1)";
		   /*----For negative testing you can simply put a dot in the "color_of_pr_btn_Expected"-----*/
		   Assert.assertEquals(color_of_pr_btn_Actual, color_of_pr_btn_Expected, "the color of the button has changed");
		   
		   /*----Convert "getCssValue(color)" in Hex format----*/
		   String[] hexValue = color_of_pr_btn_Actual.replace("rgba(", "").replace(")", "").split(",");
		   int hexValue1=Integer.parseInt(hexValue[0]);
		   hexValue[1] = hexValue[1].trim();
		   int hexValue2=Integer.parseInt(hexValue[1]);
		   hexValue[2] = hexValue[2].trim();
		   int hexValue3=Integer.parseInt(hexValue[2]);

		   String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		   String expectedColor = "#ffffff";
		   Assert.assertEquals(actualColor, expectedColor, "the color of the button has changed in Hex format");
		   
	   }
		   else if (z==false) {
			   System.out.println("FIND OUT A WAY OF HANDLING NEGATIVE SCENARIO");   }
		   }
	
	
}
