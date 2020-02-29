package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.ButtonColorValidation;
import pages.CheckboxValidation;
import pages.DatePickerValidation;
import pages.Form;
import pages.HomePage;
import pages.TitleValidation;
import pages.WebBasedPopUp;
import utility.ExcelUtils;

public class DriverScript {

	WebDriver driver;
    String sPath = "D:\\INTERVIEW\\SELENIUM\\Test_Data\\DataEngine2.xlsx";
    WebDriverWait wait;

public void launchURL() {
		   
		driver.get("http://formy-project.herokuapp.com/");
	   }
    
@BeforeTest
public void pre_requisute() {

	/*Setting up browser properties*/
	
	System.setProperty("webdriver.chrome.driver","D:\\INTERVIEW\\SELENIUM\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	/* ----The Implicit wait is not required when I am using Explicit wait (i.e. WebDriver wait). Using Implicit wait will not cause any error,
	 but it increase the TimeOut period of searching a WebElement. That means the below I am declared 10 secs as Implicit wait and down the
	 line I am using explicit wait as 5 secs, so in total I am setting out the TimeOut as (10 + 5 = 15 secs) which is unnecessary. -----*/
	 //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS); //Dynamic wait
}

@Test (priority = 1,groups = "Validation of title")
public void Jira() throws Exception {
	
	ExcelUtils.setExcelFile (sPath, 0);
	launchURL();
	TitleValidation TV = PageFactory.initElements(driver, TitleValidation.class);
	for (int iRow = 1; iRow<=1; iRow++) {
		
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		
		if (sActionKeyword.equals ("validate_title")) {
		 TV.validate_title();
		 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			
		}
}

	
@Test (priority = 2, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
//@Test (priority = 2, groups = "Validation of hyperlink")
public void JiraId_1200() throws Exception { //Validation of "DropDownMenu" functionality
		
			    ExcelUtils.setExcelFile (sPath, 0);
			    launchURL();
			    HomePage hp = PageFactory.initElements(driver, HomePage.class);
			    
				for (int iRow = 2; iRow<=3; iRow++){
				    
					String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
					
				    if (sActionKeyword.equals ("click_dropDown")) {
				    	
				    	hp.click_dropDown();
				    	ExcelUtils.updateResultPass (iRow, 5, sPath);
				    	}
				    

			        else if (sActionKeyword.equals ("validate_dropDownButton")) {
				        boolean d = hp.validate_dropDownButton();
					     if (d == true) {
					    	 ExcelUtils.updateResultPass (iRow, 5, sPath);	 
					     }
					     else if (d == false) {
					    	 ExcelUtils.updateResultFail (iRow, 5, sPath);}}
				 
		}			
}

 
@Test (priority = 3, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
//@Test (priority = 3, groups = "Validation of hyperlink")
public void JiraId_1201() throws Exception { 
	
	 		 ExcelUtils.setExcelFile (sPath, 0);
		     launchURL();
		     		     
		     HomePage hp = PageFactory.initElements(driver, HomePage.class);
		     
		     for (int iRow = 4; iRow<=5; iRow++){
			    
				String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
				
		           if (sActionKeyword.equals ("click_autoComplete")) {
		             hp.click_autoComplete();
		             ExcelUtils.updateResultPass (iRow, 5, sPath);}

                   else if (sActionKeyword.equals ("validate_autoComplete")) {
                	   ExcelUtils.setExcelFile (sPath, 1);
                	   for (int jRow = 0; jRow <= 3; jRow++) {
                		   String tab1 = ExcelUtils.getCellData (jRow, 0);
                		   
                		   String zip_code_exp = ExcelUtils.getCellData(jRow, 3); // For -ve testing, you can change some value.  
                		   hp.validate_autoComplete(tab1, zip_code_exp);
                	   }
                	   
                	   ExcelUtils.setExcelFile (sPath, 0); 
                	   ExcelUtils.updateResultPass (iRow, 5, sPath);    
                	   }
		               
}
}



@Test (priority = 4, groups = "Validation of color", dependsOnMethods = "Jira") 
//@Test (priority = 4, groups = "Validation of color")
public void JiraId_1202() throws Exception {
	
	         ExcelUtils.setExcelFile (sPath, 0);
	         launchURL();
	
	         HomePage hp = PageFactory.initElements(driver, HomePage.class);
	         ButtonColorValidation bcv = PageFactory.initElements(driver, ButtonColorValidation.class);
	         
	         for (int iRow = 6; iRow<=7; iRow++) {
	        	 String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		         if (sActionKeyword.equals ("click_Button")) {
	        		hp.click_Button();
		            ExcelUtils.updateResultPass (iRow, 5, sPath);}

				  else if (sActionKeyword.equals ("validate_buttonColor")) {
					  bcv.validate_buttonColor();
				      ExcelUtils.updateResultPass (iRow, 5, sPath);}
			 }
}


@Test (priority=5, groups = "Validation of checkbox", dependsOnMethods = "Jira")
//@Test (priority=5, groups = "Validation of checkbox")
public void Jira_1203() throws Exception {
	
	           ExcelUtils.setExcelFile (sPath, 0);
	           launchURL();
	
	           HomePage hp = PageFactory.initElements(driver, HomePage.class);
	           CheckboxValidation chkv = PageFactory.initElements(driver, CheckboxValidation.class); 
	           for (int iRow = 8; iRow<=12; iRow++) {
		 
	        	   String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		           if (sActionKeyword.equals ("click_Checkbox")) {
		        	   hp.click_Checkbox();
		        	   ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals ("validate_display_text_Checkboxes")) { 
		        	   chkv.validate_display_text_Checkboxes();
				      ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals("validate_checkbox1")) {
		        	   chkv.validate_checkbox1();
			           ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals("validate_checkbox2")) {
		        	   chkv.validate_checkbox2();
		        	   ExcelUtils.updateResultPass (iRow, 5, sPath);}
		           
		           else if (sActionKeyword.equals("validate_checkbox3")) {
		        	   chkv.validate_checkbox3();
		        	   ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 
		 }
}



@Test (priority = 8, groups = "Validation of Right Click ops", dependsOnMethods = "Jira")
//@Test (priority = 8, groups = "Validation of Right Click ops")
public void Jira_1204() throws Exception {
	
	ExcelUtils.setExcelFile (sPath, 0);
    launchURL();
    
    HomePage hp = PageFactory.initElements(driver, HomePage.class);
    
	for (int iRow = 13; iRow<=13; iRow++){
	    
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		
	    if (sActionKeyword.equals ("rightClick_autoComplete")) {
	    	
	    	hp.rightClick_autoComplete();
	    	ExcelUtils.updateResultPass (iRow, 5, sPath);
	    	}

		 }
}

@Test (priority = 6, groups = "Validation of Date picker", dependsOnMethods = "Jira") 
//@Test (priority = 6, groups = "Validation of Date picker")
public void Jira_1205() throws Exception{
	
	ExcelUtils.setExcelFile (sPath, 0);
    launchURL();
    
    HomePage hp = PageFactory.initElements(driver, HomePage.class);
    DatePickerValidation dpv = PageFactory.initElements(driver, DatePickerValidation.class);
    
    for (int iRow = 14; iRow<=16; iRow++) {
    	
    	String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
    	
    	if (sActionKeyword.equals ("click_DatePicker")) {
    		hp.click_DatePicker();
    		ExcelUtils.updateResultPass (iRow, 5, sPath);
    	}
    	else if (sActionKeyword.equals("click_DatePicker_text_field")) {
    		dpv.click_DatePicker_text_field();
    		ExcelUtils.updateResultPass (iRow, 5, sPath);
    	}
    	else if (sActionKeyword.equals("click_T_plus_7")) {
    		dpv.click_T_plus_7();
    		ExcelUtils.updateResultPass (iRow, 5, sPath);
    	}
    }
}

//@Test (priority = 7, groups = "Form Submission", dependsOnMethods = "Jira")
/* PS: This particular test case works fine in isolation, but when we try to run it along with other test cases, it fails out.
 * Below errors encountered:
 * org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//input[@type= 'text' and @class= 'form-control' and @id= 'first-name' and @placeholder= 'Enter first name']"}
 * 
 * Sometimes it says:org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
 *  
 *  So the test seems to be very flaky in nature.
 *  
 *  Action Item: 1. RCA
 *  Workaround: For now, I have removed the tag <input> and replaced with <*>. It works fine*/

@Test (priority = 7, groups = "Form Submission")
public void JiraId_1206() throws Exception {

	ExcelUtils.setExcelFile (sPath, 0);
    launchURL();
    
    HomePage hp = PageFactory.initElements(driver, HomePage.class);
    Form frm = PageFactory.initElements(driver, Form.class);
  
    for (int iRow = 17; iRow<=18; iRow++) {
	String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
	if (sActionKeyword.equals ("click_Form")) {
		hp.click_Form();
		ExcelUtils.updateResultPass (iRow, 5, sPath);}
    else if (sActionKeyword.equals ("submit_Form")) {
		ExcelUtils.setExcelFile (sPath, 2);
		for (int jRow = 1; jRow <=3; jRow++) {
			
			String FName = ExcelUtils.getCellData(jRow, 0);
	        String LName = ExcelUtils.getCellData(jRow, 1);
			String JobTitle = ExcelUtils.getCellData(jRow, 2);
			String EduLevel = ExcelUtils.getCellData(jRow, 3);
			String Gender = ExcelUtils.getCellData(jRow, 4);
			String Exp = ExcelUtils.getCellData(jRow, 5);
			
			//Below code describes how to convert a Date into a String.
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			Date user_Date = sdf1.parse(ExcelUtils.getCellData(jRow, 6));
			String dateString = sdf1.format(user_Date);
			
			System.out.println(FName);
			System.out.println(LName);
			System.out.println(JobTitle);
			System.out.println(EduLevel);
			System.out.println(Gender);
			System.out.println(Exp);
			System.out.println(dateString);
			
			frm.submit_Form(FName, LName, JobTitle, EduLevel, Gender, Exp, dateString);
			Thread.sleep(2000);
			driver.navigate().back();
		}
		ExcelUtils.setExcelFile (sPath, 0); 
        ExcelUtils.updateResultPass (iRow, 5, sPath);
	}
	}
    }

@Test (priority = 8, groups = "Web based pop-ups", dependsOnMethods = "Jira")
//@Test (priority = 8, groups = "Web based pop-ups")
public void JiraId_1207() throws Exception {
	
	ExcelUtils.setExcelFile(sPath, 0);
	launchURL();
	
	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	WebBasedPopUp wbp = PageFactory.initElements(driver, WebBasedPopUp.class);
	
	for (int iRow = 19; iRow <= 21; iRow++ ) {
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		if (sActionKeyword.equals ("clickSwitchWindow")) {
			hp.clickSwitchWindow();
			ExcelUtils.updateResultPass (iRow, 5, sPath);
			}
		else if (sActionKeyword.equals("clickOpenAlert")) {
			wbp.clickOpenAlert();
			ExcelUtils.updateResultPass (iRow, 5, sPath);
		}
		else if (sActionKeyword.equals("closeSimpleAlert")) {
			wbp.closeSimpleAlert();
			ExcelUtils.updateResultPass (iRow, 5, sPath);
		}		
	}
}

@AfterTest
public void closeTheSession() throws Throwable {
   driver.quit();
}

}

