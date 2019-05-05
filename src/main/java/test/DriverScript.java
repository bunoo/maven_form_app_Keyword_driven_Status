package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.ButtonColorValidation;
import pages.CheckboxValidation;
import pages.DatePickerValidation;
import pages.HyperlinkValidation;
import pages.TitleValidation;
import utility.ExcelUtils;

public class DriverScript {

	WebDriver driver;
    String sPath = "C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\TCS\\TestData\\DataEngine2.xlsx";
    WebDriverWait wait;

public void launchURL() {
		   
		driver.get("http://formy-project.herokuapp.com/");
		
	   }
    
@BeforeTest
public void pre_requisute() {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\SELENIUM\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	/* ----The Implicit wait is not required when I am using Explicit wait (i.e. WebDriver wait). Using Implicit wait will not cause any error,
	 but it increase the TimeOut period of searching a WebElement. That means the below I am declared 10 secs as Implicit wait and down the
	 line I am using explicit wait as 5 secs, so in total I am setting out the TimeOut as (10 + 5 = 15 secs) which is unnecessary. -----*/
	 //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS); //Dynamic wait
}
//Q - HOW CAN I ENSURE THAT MY APPROACH IS GENERALISED IN CASE WHEREIN I NEED TO RUN A SELECTED NO. OF TEST CASES 
//ANS - SIMPLY COMMENT OUT THOSE TEST CASES.

@Test (priority = 1,groups = "Validation of title")
public void Jira() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	launchURL();
	TitleValidation TV = new TitleValidation (driver, wait);
	for (int iRow = 1; iRow<=1; iRow++) {
		
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		
		if (sActionKeyword.equals ("validate_title")) {
		 TV.validate_title();
		 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			
		}
}

	
//@Test (priority = 2, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
@Test (priority = 2, groups = "Validation of hyperlink")
public void JiraId_1200() throws Exception {
		
			    ExcelUtils.setExcelFile (sPath);
			    launchURL();
			    HyperlinkValidation HV = PageFactory.initElements(driver, HyperlinkValidation.class);
			    
				for (int iRow = 2; iRow<=3; iRow++){
				    
					String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
					
				    if (sActionKeyword.equals ("click_dropDown")) {
				    	
				    	HV.click_dropDown();
				    	ExcelUtils.updateResultPass (iRow, 5, sPath);
				    	}
				    

			        else if (sActionKeyword.equals ("validate_dropDownButton")) {
				        boolean d = HV.validate_dropDownButton();
					     if (d == true) {
					    	 ExcelUtils.updateResultPass (iRow, 5, sPath);	 
					     }
					     else if (d == false) {
					    	 ExcelUtils.updateResultFail (iRow, 5, sPath);}}
				 
		}			
}

 
//@Test (priority = 3, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
@Test (priority = 3, groups = "Validation of hyperlink")
public void JiraId_1201() throws Exception {
	
	 		 ExcelUtils.setExcelFile (sPath);
		     launchURL();
		     
//Q. In Test Case, @Test(P=2) I have already created the instance "HV". In @Test(P=3), do I need to recreate the instance if I want to use methods of "HyperlinkVaidation.java" class?
//Ans - Yes, you need to recreate because once system execute @Test(P=2), it dumps the object "HV". 
		     
		     HyperlinkValidation HV = PageFactory.initElements(driver, HyperlinkValidation.class);
		     for (int iRow = 4; iRow<=5; iRow++){
			    
				String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
				
		           if (sActionKeyword.equals ("click_autoComplete")) {
		             HV.click_autoComplete();
		             ExcelUtils.updateResultPass (iRow, 5, sPath);}

                   else if (sActionKeyword.equals ("validate_autoComplete")) {
                	   HV.validate_autoComplete();
		               ExcelUtils.updateResultPass (iRow, 5, sPath);}
}
}


//@Test (priority = 4, groups = "Validation of color", dependsOnMethods = "Jira") 
@Test (priority = 4, groups = "Validation of color")
public void JiraId_1202() throws Exception {
	
	         ExcelUtils.setExcelFile (sPath);
	         launchURL();
	
	         ButtonColorValidation BV = PageFactory.initElements(driver, ButtonColorValidation.class);
	         for (int iRow = 6; iRow<=7; iRow++) {
		 
	        	 String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		 
	        	 if (sActionKeyword.equals ("click_Button")) {
	        		BV.click_Button();
		            ExcelUtils.updateResultPass (iRow, 5, sPath);}

				  else if (sActionKeyword.equals ("validate_buttonColor")) {
				 BV.validate_buttonColor();
				 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			 }
}


//@Test (priority=5, groups = "Validation of checkbox", dependsOnMethods = "Jira")
@Test (priority=5, groups = "Validation of checkbox")
public void Jira_1203() throws Exception {
	
	           ExcelUtils.setExcelFile (sPath);
	           launchURL();
	
	           CheckboxValidation CV = PageFactory.initElements(driver, CheckboxValidation.class); 
	           for (int iRow = 8; iRow<=12; iRow++) {
		 
	        	   String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		           if (sActionKeyword.equals ("click_Checkbox")) {
		        	   CV.click_Checkbox();
		        	   ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals ("validate_display_text_Checkboxes")) { 
			          CV.validate_display_text_Checkboxes();
				      ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals("validate_checkbox1")) {
		        	   CV.validate_checkbox1();
			           ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals("validate_checkbox2")) {
		        	   CV.validate_checkbox2();
		        	   ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals("validate_checkbox3")) {
		        	   CV.validate_checkbox3();
		        	   ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 
		 }
}


//@Test (priority = 6, groups = "Validation of Right Click ops", dependsOnMethods = "Jira")
@Test (priority = 7, groups = "Validation of Right Click ops")
public void Jira_1204() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
    launchURL();
    HyperlinkValidation HV = PageFactory.initElements(driver, HyperlinkValidation.class);
    
	for (int iRow = 13; iRow<=13; iRow++){
	    
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		
	    if (sActionKeyword.equals ("rightClick_autoComplete")) {
	    	
	    	HV.rightClick_autoComplete();
	    	ExcelUtils.updateResultPass (iRow, 5, sPath);
	    	}

		 }
}

//@Test (priority = 7, groups = "Validation of Date picker", dependsOnMethods = "Jira")
@Test (priority = 6, groups = "Validation of Date picker")
public void Jira_1205() throws Exception{
	
	ExcelUtils.setExcelFile (sPath);
    launchURL();
    DatePickerValidation DP = PageFactory.initElements(driver, DatePickerValidation.class);
    
    for (int iRow = 14; iRow<=16; iRow++) {
    	
    	String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
    	
    	if (sActionKeyword.equals ("click_DatePicker")) {
    		DP.click_DatePicker();
    		ExcelUtils.updateResultPass (iRow, 5, sPath);
    	}
    	else if (sActionKeyword.equals("click_DatePicker_text_field")) {
    		DP.click_DatePicker_text_field();
    		ExcelUtils.updateResultPass (iRow, 5, sPath);
    	}
    	else if (sActionKeyword.equals("click_T_plus_7")) {
    		DP.click_T_plus_7();
    		ExcelUtils.updateResultPass (iRow, 5, sPath);
    	}
    }
}

/*@AfterTest
public void closeTheSession() {
	
   driver.quit();
}*/

}
