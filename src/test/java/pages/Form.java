package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form extends HomePage {

	/*Parameterized Constructor*/	
	public Form (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions (driver);
        PageFactory.initElements(driver,this);
    }
	
	/* Define web elements using @FindBy annotation */
	//@FindBy (xpath = "//a[@class='btn btn-lg' and @href='/form']") WebElement Form;
	@FindBy (xpath = "//input[@type= 'text' and @class= 'form-control' and @id= 'first-name' and @placeholder= 'Enter first name']") WebElement fName;
	@FindBy (id="last-name") WebElement lName;
	@FindBy (id="job-title") WebElement jobTitle;
	
	@FindBy (id="radio-button-1") WebElement highSchool;
	@FindBy (id="radio-button-2") WebElement college;
	@FindBy (id="radio-button-3") WebElement gradSchool;
	@FindBy (id="checkbox-1") WebElement sexMale;
	@FindBy (id="checkbox-2") WebElement sexFemale;
	@FindBy (id="checkbox-3") WebElement sexNo;
	@FindBy (xpath = "//select [@class='form-control' and @id = 'select-menu']") WebElement UserExp;
	@FindBy (xpath = "//input[@type='text' and @class='form-control' and @id='datepicker' and @data-provide='datepicker' and @placeholder='mm/dd/yyyy' and @data-date-autoclose='true' and @data-date-today-highlight='true']") WebElement date;
	@FindBy (xpath = "//a[@class='btn btn-lg btn-primary' and @role='button' and @href='/thanks']") WebElement submit_btn;
	/*Below are the implementations*/
	public void click_Form() {
		
		wait.until(ExpectedConditions.visibilityOf(Form)).click();
	}
	
	/* public void submit_Form (String EduLevel){
        
        if (EduLevel == "hs") {
			highSchool.click();
		}
		else if (EduLevel == "college") {
			college.click();
		}
		else if (EduLevel == "grad") {
			gradSchool.click();
		}
		
	    if (EduLevel.equals("hs")) {
	    	highSchool.click();
	    }
	    } */ // It does not work. Probably "==" is applicable only when you are comparing a String value with a boolean. Confirm ??
    
public void submit_Form (String FName, String LName, String JobTitle, String EduLevel, String Gender, String Exp, String dateString) {
	   
	fName.clear();
	fName.sendKeys(FName);
	lName.clear();
	lName.sendKeys(LName);
	jobTitle.clear();
	jobTitle.sendKeys(JobTitle);
		
	    // EduLevel 
		if (EduLevel.equals("hs")) {
			highSchool.click();
		}
		else if (EduLevel.equals("grad")) {
			gradSchool.click();
		}
		else if (EduLevel.equals("college")) {
			college.click();
		}
		
		 //Gender 
		if (Gender.equals("Female")) {
			sexFemale.click();
		}
		else if (Gender.equals("Male")) {
			sexMale.click();
		}
		else if (Gender.equals("NotSure")) {
			sexNo.click();
		}
		
		//Experience
		if (Exp.equals("a10+")) {
			UserExp.click();
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		}
		else if (Exp.equals("a(2-4)")) {
			UserExp.click();
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		}
		else if (Exp.equals("a(5-9)")) {
			UserExp.click();
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		}
		
		//Calendar
		date.clear();
		date.sendKeys(dateString);
		actions.sendKeys(Keys.RETURN).build().perform();
		
		//Click on Submit button
		submit_btn.click();
		
	}

}
