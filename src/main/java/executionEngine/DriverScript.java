package executionEngine;

import config.ActionKeywords;
import utility.ExcelUtils;

// Tried to use all the classes from ExcelUtils.java class but it says it is never been used


public class DriverScript {
public static void main (String[] args) throws Exception {
	ActionKeywords AK = new ActionKeywords();
//Declaring the path of the Excel file with the name of the Excel file
String sPath = "C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\TCS\\TestData\\DataEngine2.xlsx";
//String sSheetName = "Test_Steps";

//Here we are pasing the Excel path and SheetName as arguments to connect with Excel file
ExcelUtils.setExcelFile(sPath);

//Hard coded values are used for Excel row and columns for now
//In later chapters we will replace these hard coded values with variables
//This is the loop for reading the values of the column 3 (Action Keyword) row by row

for (int iRow = 1; iRow<=2; iRow++){
    //Storing the value of excel cell in sActionKeyword string variable
    String sActionKeyword = ExcelUtils.getCellData (iRow, 3);
    
 //Comparing the value of Excel cell with all the project keywords
 if (sActionKeyword.equals ("invokeBrowser")){
    //This will execute if the excel cell value is 'invokeBrowser'
    //ActionKeyword is called here to perform action
	 //ActionKeywords.invokeBrowser(); // It is yeilding an error saying that non-static method can not be called from a static method
	 AK.invokeBrowser();
	 //Think how to validate invokeBrowser() and put in the code for the same
	 ExcelUtils.updateResultPass (iRow, 4, sPath);
     	 
 }
 
 else if (sActionKeyword.equals ("dropDownMenu")){

     boolean d = AK.dropDownMenu();
     if (d == true) {
    	 ExcelUtils.updateResultPass (iRow, 4, sPath);	 
     }
     else if (d == false) {
    	 ExcelUtils.updateResultFail (iRow, 4, sPath);
     }
     }
     	 
 }

}
}

