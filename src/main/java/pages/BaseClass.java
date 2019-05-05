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
//Puitting the 2nd commit to check my trigger on TeamCity. 
public class BaseClass {

   WebDriver driver;
   
   JavascriptExecutor jse;
   WebDriverWait wait;
 	 
   
 
   public void Datepicker() { //TO BE IMPEMENTED - choose a date which is "T+7" from the calendar and then close the calendar. 
		
   
   
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
   


   public void fileupload() {
	   try {
		   
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
	       
           WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
		   WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/buttons']")));
		   btn.click();
		   String fsize = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-lg btn-link']")).getCssValue("font-size");
		   System.out.println("font size is "+fsize);
	} 
   
   
   public void backgroundColor() {
	   
	  
       WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit wait
	   WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/buttons']")));
	   btn.click();
	   String btn_bg = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-lg btn-link']")).getCssValue("background-color");
	   System.out.println("Background color is "+btn_bg);
	   
   }
   
      }
   
   

