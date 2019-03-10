package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.HyperlinkValidation;
import pages.TitleValidation;
import utility.ExcelUtils;

public class DriverScript {

	
	BaseClass BC = new BaseClass(); //We are creating an object for "ActionKeywords.java" class. In this case, CONSTRUCTOR gets automatically created
	HyperlinkValidation HV = new HyperlinkValidation();
	TitleValidation TV = new TitleValidation();
	
	String sPath = "C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\TCS\\TestData\\DataEngine2.xlsx";

@BeforeTest
public void pre_requisute() {
	
	BC.invokeBrowser();
	BC.launchURL(); }

//Q - HOW CAN I ENSURE THAT MY APPROACH IS GENERALISED IN CASE WHEREIN I NEED TO RUN A SELECTED NO. OF TEST CASES 
//ANS - SIMPLY COMMENT OUT THOSE TEST CASES.

@Test (priority = 1,groups = "Validation of title")
public void Jira() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
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
				for (int iRow = 2; iRow<=4; iRow++){
				    
					String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
				  
				    if (sActionKeyword.equals ("invokeBrowser")){
					     BC.invokeBrowser();
						 ExcelUtils.updateResultPass (iRow, 5, sPath);
					 }
				    
				    else if (sActionKeyword.equals ("click_dropDown")) {
				    	HV.click_dropDown();
				    	ExcelUtils.updateResultPass (iRow, 5, sPath);}
				    

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
		 
		 for (int iRow = 5; iRow<=6; iRow++){
			    
				String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
				
		if (sActionKeyword.equals ("click_autoComplete")) {
		HV.click_autoComplete();
		ExcelUtils.updateResultPass (iRow, 5, sPath);}

        else if (sActionKeyword.equals ("validate_autoComplete")) {
		HV.validate_autoComplete();
		ExcelUtils.updateResultPass (iRow, 5, sPath);}
}
	} 
	


@Test (priority = 4, groups = "Validation of color", dependsOnMethods = "Jira") 
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
	
   BC.closeBrowser();
}

}



		

	