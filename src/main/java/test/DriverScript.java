package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.HyperlinkValidation;
import pages.TitleValidation;
import utility.ExcelUtils;

public class DriverScript {

	WebDriver driver;
    String sPath = "C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\TCS\\TestData\\DataEngine2.xlsx";

public void launchURL() {
		   
		driver.get("http://formy-project.herokuapp.com/");
		
	   }
    
@BeforeTest
public void pre_requisute() {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\SELENIUM\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	//launchURL();
}
//Q - HOW CAN I ENSURE THAT MY APPROACH IS GENERALISED IN CASE WHEREIN I NEED TO RUN A SELECTED NO. OF TEST CASES 
//ANS - SIMPLY COMMENT OUT THOSE TEST CASES.

@Test (priority = 1,groups = "Validation of title")
public void Jira() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	launchURL();
	TitleValidation TV = new TitleValidation (driver);
	for (int iRow = 1; iRow<=1; iRow++) {
		
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		
		if (sActionKeyword.equals ("validate_title")) {
		 TV.validate_title();
		 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			
		}
	}

	
@Test (priority = 2, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
public void JiraId_1200() throws Exception {
		
			    ExcelUtils.setExcelFile (sPath);
			    launchURL();
			    HyperlinkValidation HV = new HyperlinkValidation(driver);
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

 
@Test (priority = 3, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
public void JiraId_1201() throws Exception {
	
	 		 ExcelUtils.setExcelFile (sPath);
		     launchURL();
		     
//Q. In Test Case, @Test(P=2) I have already created the instance "HV". In @Test(P=3), do I need to recreate the instance if I want to use methods of "HyperlinkVaidation.java" class?
//Ans - Yes, you need to recreate because once system execute @Test(P=2), it dumps the object "HV". 
		     
		     
		     HyperlinkValidation HV = new HyperlinkValidation(driver);
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
	


/*@Test (priority = 4, groups = "Validation of color", dependsOnMethods = "Jira") 
public void JiraId_1202() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	for (int iRow = 7; iRow<=8; iRow++) {
		 String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		 if (sActionKeyword.equals ("click_Button")) {
			BC.click_Button();
		     ExcelUtils.updateResultPass (iRow, 5, sPath);}

				        else if (sActionKeyword.equals ("validate_buttonColor")) {
						BC.validate_buttonColor();
						ExcelUtils.updateResultPass (iRow, 5, sPath);}
			 }
		} 
*/

/*@Test (priority=5, groups = "Validation of checkbox", dependsOnMethods = "Jira")
public void Jira_1203() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	for (int iRow = 9; iRow<=13; iRow++) {
		 String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		 if (sActionKeyword.equals ("click_Checkbox")) {
			 BC.click_Checkbox();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 else if (sActionKeyword.equals ("validate_display_text_Checkboxes")) {
			 String w = BC.validate_display_text_Checkboxes();
			 if (w == "PASS") {
				 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			 
			 else if (w == "FAIL") {
				 ExcelUtils.updateResultFail (iRow, 5, sPath);}
			 
			 ExcelUtils.updateResultPass (iRow, 5, sPath);
			 
		     }
		 
		 else if (sActionKeyword.equals("validate_checkbox1")) {
			 BC.validate_checkbox1();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 else if (sActionKeyword.equals("validate_checkbox2")) {
			 BC.validate_checkbox2();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 else if (sActionKeyword.equals("validate_checkbox3")) {
			 BC.validate_checkbox3();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 
		 }
	}*/

@AfterTest
public void closeTheSession() {
	
   driver.quit();
}

}



		

	