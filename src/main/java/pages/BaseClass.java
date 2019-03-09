package pages;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Putting this comment to check my trigger on TeamCity. Thank You.

public class BaseClass {

   WebDriver driver;
   JavascriptExecutor jse;
   WebDriverWait wait;
   
   
   public void invokeBrowser() {
	   
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\SELENIUM\\chromedriver\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
   }
   
   
   
   public void launchURL() {
	   driver.get("http://formy-project.herokuapp.com/");  
   }

   
   public void click_Button() {
	   launchURL();
	   WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
	   WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/buttons']")));
       btn.click();
   }
   
   public void validate_buttonColor()   {
	   
	   WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
	   WebElement prButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @class='btn btn-lg btn-primary']")));
	   boolean z = prButton.isDisplayed();
	    
	   
	   if (z==true) {
	   String PRIMARYbtnColor = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-lg btn-primary']")).getCssValue("color");
	   System.out.println("PRIMARY button color is "+PRIMARYbtnColor);
	     
	   String[] hexValue = PRIMARYbtnColor.replace("rgba(", "").replace(")", "").split(",");
	   int hexValue1=Integer.parseInt(hexValue[0]);
	   hexValue[1] = hexValue[1].trim();
	   int hexValue2=Integer.parseInt(hexValue[1]);
	   hexValue[2] = hexValue[2].trim();
	   int hexValue3=Integer.parseInt(hexValue[2]);

	   String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
	   System.out.println("PRIMARY button color is "+actualColor);  //This returns "PRIMARY button color is #ffffff"
   }
	   else if (z==false) {
		   System.out.println("FIND OUT A WAY OF HANDLING NEGATIVE SCENARIO");   }
	   }
   
   
   public void Datepicker() { //TO BE IMPEMENTED - choose a date which is "T+7" from the calendar and then close the calendar. 
		
   
   launchURL();
   WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
   WebElement Components = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbarDropdownMenuLink")));       
   Components.click();
   WebElement date = driver.findElement(By.xpath("//a[@class='btn btn-lg' and @href='/datepicker']"));
   date.click();
   
   WebElement dateField = driver.findElement(By.id("datepicker"));
   dateField.click();
   //Thread.sleep(5000); // Try to know how to use Explicit wait with Gregorian Calendar and then use the same. 
   Calendar calendar = new GregorianCalendar();
   int currentDate = calendar.get(Calendar.DAY_OF_MONTH);
   System.out.println("date is"+currentDate);
   int sevendays = currentDate + 7;
   System.out.println("T+7 is "+sevendays); //Working fine
   driver.findElement(By.xpath("//td[contains(text(),sevendays)]")).click();//It worked well, but it is choosing a wrong date. See the output: date is31 7 date is38
	} 
				   
	
   
 public void DragAndDrop(){
	   
	   try {
		   WebElement dragDrop = driver.findElement(By.xpath("//a[@class='btn btn-lg' and @href='/dragdrop']"));
		   dragDrop.click();
		   
		   Thread.sleep(5000);
		   
		   WebElement From = driver.findElement(By.xpath("//*[@id='image']"));
           WebElement To = driver.findElement(By.xpath("//*[@id='box']"));

		   Actions act = new Actions(driver); //This also can be a culprit
		   act.dragAndDrop(From, To).build().perform(); //It is not working. Probably we need to apply dynamic wait time in place of Thread.sleep
		   
		   act.dragAndDropBy(From, 215, 215).build().perform();//This is also not working
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
 
 
 
 //NEW COMMENT : The below code is working fine except the test not printing the FALSE value
/*public boolean dropDownMenu() { 
	//We first click on "Components" and then click on "dropDonMenu" option
			   launchURL();
			   WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
			   WebElement Components = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbarDropdownMenuLink")));
			   Components.click();
			   WebElement dropdown = driver.findElement(By.xpath("//a[@class='dropdown-item' and @href='/dropdown']"));				   
			   dropdown.click();
			   try {
				Thread.sleep(5000); //Later on put dynamic wait
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			   //Validation Step
			   boolean a = driver.findElement(By.id("dropdownMenuButton")).isDisplayed();
			    //boolean a = driver.findElement(By.id("intentionallyFailing")).isDisplayed();
				System.out.println("The value is "+a); //-- It will print the value
				return a;
			
			   //System.out.println("The value is "+a); -- It will not print because you already emptied the string. That is why I have used it b4 returning
			   }*/ 

 
 //LEARNING BITE ----The below piece of code never works. The goal was to update the result column of excel sheet. 
 //Since "Assert.assertequals ()" never returns a value so it is not possible to store its outcome in any variable and hance we can not
 //return any conclusion to the DriverScript. Since DriverScript is not receiving any output from dropDown() method, so it cannot update the result

 /*   public void dropDownMenu() throws Exception { 

				   launchURL();
				   WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
				   WebElement Components = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbarDropdownMenuLink")));
				   Components.click();
				   WebElement dropdown = driver.findElement(By.xpath("//a[@class='dropdown-item' and @href='/dropdown']"));				   
				   dropdown.click();
				   Thread.sleep(5000);
					
				   WebElement y = driver.findElement(By.id("dropdownMenuButton"));
				   String b =y.getText();
                   System.out.println(b); //Dropdown button
                   Assert.assertEquals (b, "Dropdown Button","FAIL");
                   //String x = "PASS";
                   
				   } */

   public void fileupload() {
	   try {
		   launchURL();
		   Thread.sleep(4000); // Try to know how to use Explicit wait with jse and then use the same
		   jse = (JavascriptExecutor)driver;
		   jse.executeScript("scroll(0,800)");
		   WebElement upload = driver.findElement(By.xpath("//a[@class='btn btn-lg' and @href='/fileupload']"));
		   upload.click();
		   
		   Thread.sleep(4000);
		 
		   
		   WebElement fileurl = driver.findElement(By.id("file-upload-field"));
		   fileurl.sendKeys("C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\SELENIUM\\File_upload.txt");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void fontSize(){ //We are directly clicking on "button" from the HomePage
	       launchURL();
           WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
		   WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/buttons']")));
		   btn.click();
		   String fsize = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-lg btn-link']")).getCssValue("font-size");
		   System.out.println("font size is "+fsize);
	} 
   
   
   public void backgroundColor() {
	   
	   launchURL();
       WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
	   WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/buttons']")));
	   btn.click();
	   String btn_bg = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-lg btn-link']")).getCssValue("background-color");
	   System.out.println("Background color is "+btn_bg);
	   
   }
   
   public void click_Checkbox() {
	   
	   launchURL();
	   WebDriverWait wait=new WebDriverWait(driver, 5); //Explicit wait
	   WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/checkbox']")));
	   checkbox.click();  
   }
   
   public void validate_display_text_Checkboxes () {
	   
	 //BELOW SCENARIO IS FAILING INTENTIONALLY. IF YOU WANT TO GET IT PASSES, REMOVE THE ".." FROM THE OBJECT LOCATOR
	   boolean act_contain_chkboxes = driver.getPageSource().contains("Checkboxes");
	   boolean exp_contain_chkboxes = driver.getPageSource().contains("FAIL");
	   //Assert.assertEquals(contain_chkboxes, true, "CHECKBOXES TEXT IS MISSING ON THE PAGE");}
	   Assert.assertEquals(act_contain_chkboxes, exp_contain_chkboxes);
   }
   
   public void validate_checkbox1 () {
	   //WebElement chkbox1 = driver.findElement(By.xpath("//input[@type='checkbox' and id='checkbox-1' and aria-label='checkbox' and value='checkbox-1']"));
	   WebElement chkbox1 = driver.findElement(By.id("checkbox-1")); //TRY TO IDENTIFY THE ELEMENT USING THE XPATH AS WRITTEN ABOVE. DIAGNOSE THE PROBLEM WHY THAT IS FAILING
	   boolean a = chkbox1.isDisplayed(); // LATER ON TRY THIS WITH ASSERT CLASS
	   
	   if (a == true) {
		   chkbox1.click();
		   
          boolean isChecked1 = chkbox1.isSelected();
		   
		   if (isChecked1 == true) {
			   Assert.assertEquals(isChecked1, true, "USER IS NOT ABLE TO SELECT THE CHECKBOX1");}
		   
	   }
	   

	   else if (a == false) {
		   // write down testNG code which results into failure. The benefit is that the error details will be displayed in the testNG reports
	   }
     }
	  
	   
   public void validate_checkbox2 () {	  
	   WebElement chkbox2 = driver.findElement(By.id("checkbox-2"));
	   boolean b = chkbox2.isDisplayed();
	   
	   if (b == true) {
		   chkbox2.click();
		   boolean isChecked2 = chkbox2.isSelected();
		   
		   if (isChecked2 == true) {
			   Assert.assertEquals(isChecked2, true, "USER IS NOT ABLE TO SELECT THE CHECKBOX1");}
		   
	   }
	   
	   else if (b == false) {
		   // write down testNG code which results into failure. The benefit is that the error details will be displayed in the testNG reports
	   }
	}
   
   
   public void validate_checkbox3 () {	  
	   WebElement chkbox3 = driver.findElement(By.id("checkbox-3"));
	   boolean c = chkbox3.isDisplayed();
	   
	   if (c == true) {
		   chkbox3.click();
           boolean isChecked3 = chkbox3.isSelected();
		   
		   if (isChecked3 == true) {
			   Assert.assertEquals(isChecked3, true, "USER IS NOT ABLE TO SELECT THE CHECKBOX1");}
	   }
	   
	   else if (c == false) {
		   // write down testNG code which results into failure. The benefit is that the error details will be displayed in the testNG reports
	   }
	}
   
   public void closeBrowser() {
	   driver.quit();
   }
   
   
   
}
