package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell; // These are classes
import org.apache.poi.xssf.usermodel.XSSFSheet; // These are classes
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // These are classes


public class ExcelUtils {
	private static XSSFSheet ExcelWSheet; 
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	//This method is to set the File path and to open the excel file
	//Pass Excel Path and SheetName as Arguments to this method
	
	public static void setExcelFile(String Path) { 
	    
			try {
				//Open the Excel file
				FileInputStream ExcelFile = new FileInputStream (Path);
				//Access the required Test Data sheet
				
				ExcelWBook = new XSSFWorkbook (ExcelFile);
				//ExcelWSheet = ExcelWBook.getSheet(SheetName);
				ExcelWSheet = ExcelWBook.getSheetAt(0);
				//ExcelWSheet.getRowCount () --TRy to know how to get the total no. of rows
				//ExcelWSheet.addcolumn () -- There is no explicit way of adding a column. It can be done indirectly. Fill in the cell with value = "Result"
				//ExcelWSheet.addSheet () //How to add a new sheet
				//Do "ExcelWSheet." and try to explore other functions as much as possibe
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	

	
	//This method is to read the test data from the Excel cell
	//IN this we are passing parameters/arguments as RowNum and ColNum
	
	public static String getCellData (int RowNum, int ColNum) throws Exception{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum); //It gets co-ordinates of the intended cell (e.g. 1,4) and stores in Cell variable
		String CellData = Cell.getStringCellValue(); // It gets the string value corresponding to the Cell co-ordinate
		return CellData;
	}
	
	public void clear_cellData (int RowNum, int ColNum) {
		
		
	}
	
	public static void updateResultPass (int resultRow, int resultCol, String optStream) {
		
		try {
			ExcelWSheet.getRow (resultRow).createCell(resultCol).setCellValue("PASS");
			//NEW CODE
			FileOutputStream foutPass = new FileOutputStream (optStream);
			ExcelWBook.write(foutPass);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void updateResultFail (int resultRow, int resultCol, String optStream) {
		try {
			ExcelWSheet.getRow (resultRow).createCell(resultCol).setCellValue("FAIL");
			FileOutputStream foutFail = new FileOutputStream (optStream);
			ExcelWBook.write(foutFail);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	

	
