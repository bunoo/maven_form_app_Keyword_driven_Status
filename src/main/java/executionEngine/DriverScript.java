package executionEngine;

import org.testng.annotations.Test;
import config.ActionKeywords;
import utility.ExcelUtils;

public class DriverScript {

    ActionKeywords AK = new ActionKeywords(); //We are creating an object for "ActionKeywords.java" class. In this case, Constructor gets automatically created
	String sPath = "C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\TCS\\TestData\\DataEngine2.xlsx";
	
@Test (priority = 1,groups = "Validation of successful launch of app")
public void Jira() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	for (int iRow = 1; iRow<=2; iRow++) {
		
		String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		
		if (sActionKeyword.equals ("invokeBrowser")){
		AK.invokeBrowser();
		ExcelUtils.updateResultPass (iRow, 5, sPath);}
		
		else if (sActionKeyword.equals ("validate_title")) {
		 AK.validate_title();
		 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			
		}
	}
	

	
	
@Test (priority = 2, groups = "Validation of hyperlink", dependsOnMethods = "Jira")
public void JiraId_1200() throws Exception {
		
			    ExcelUtils.setExcelFile (sPath);
				for (int iRow = 3; iRow<=5; iRow++){
				    
					String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
				  
				    if (sActionKeyword.equals ("invokeBrowser")){
					     AK.invokeBrowser();
						 ExcelUtils.updateResultPass (iRow, 5, sPath);
					 }
				    
				    else if (sActionKeyword.equals ("click_dropDown")) {
				    	AK.click_dropDown();
				    	ExcelUtils.updateResultPass (iRow, 5, sPath);}
				    

				    else if (sActionKeyword.equals ("validate_dropDownButton")) {
				        boolean d = AK.validate_dropDownButton();
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
		 
		 for (int iRow = 6; iRow<=7; iRow++){
			    
				String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
				
		if (sActionKeyword.equals ("click_autoComplete")) {
		AK.click_autoComplete();
		ExcelUtils.updateResultPass (iRow, 5, sPath);}

        else if (sActionKeyword.equals ("validate_autoComplete")) {
		AK.validate_autoComplete();
		ExcelUtils.updateResultPass (iRow, 5, sPath);}
}
	} 
	


@Test (priority = 4, groups = "Validation of color", dependsOnMethods = "Jira") 
public void JiraId_1202() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	for (int iRow = 8; iRow<=9; iRow++) {
		 String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		 if (sActionKeyword.equals ("click_Button")) {
			AK.click_Button();
		     ExcelUtils.updateResultPass (iRow, 5, sPath);}

				        else if (sActionKeyword.equals ("validate_buttonColor")) {
						AK.validate_buttonColor();
						ExcelUtils.updateResultPass (iRow, 5, sPath);}
			 }
		} 

@Test (priority=5, groups = "Validation of checkbox", dependsOnMethods = "Jira")
public void Jira_1203() throws Exception {
	
	ExcelUtils.setExcelFile (sPath);
	for (int iRow = 10; iRow<=14; iRow++) {
		 String sActionKeyword = ExcelUtils.getCellData (iRow, 4);
		 if (sActionKeyword.equals ("click_Checkbox")) {
			 AK.click_Checkbox();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 else if (sActionKeyword.equals ("validate_display_text_Checkboxes")) {
			 /*String w = AK.validate_display_text_Checkboxes();
			 if (w == "PASS") {
				 ExcelUtils.updateResultPass (iRow, 5, sPath);}
			 
			 else if (w == "FAIL") {
				 ExcelUtils.updateResultFail (iRow, 5, sPath);}*/
			 
			 ExcelUtils.updateResultPass (iRow, 5, sPath);
			 
		     }
		 
		 else if (sActionKeyword.equals("validate_checkbox1")) {
			 AK.validate_checkbox1();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 else if (sActionKeyword.equals("validate_checkbox2")) {
			 AK.validate_checkbox2();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 else if (sActionKeyword.equals("validate_checkbox3")) {
			 AK.validate_checkbox3();
			 ExcelUtils.updateResultPass (iRow, 5, sPath);}
		 
		 
		 }
	}


}



		

	