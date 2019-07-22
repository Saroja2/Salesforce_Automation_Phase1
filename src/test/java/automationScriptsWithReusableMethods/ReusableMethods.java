package automationScriptsWithReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {
	
	
	static WebDriver driver;
	static ExtentTest logger;
	
	static	String fileName = new SimpleDateFormat("'SalesForce_'yyyyMMddHHmmss'.html'").format(new Date());
	
	static ExtentReports report = new ExtentReports("/Users/Saroja/Documents/Seleniumtraining/SalesForceAutomationExtentReports/" + fileName);
	
	public static void launchUrl()
	{
		
		driver.get("https://www.salesforce.com");
		driver.manage().window().maximize();
		System.out.println("Salesforce application opened");
		
	}		
	
	
	
	
	public static ExtentTest CreateTestScriptReport(String TestScriptName) 
	{
		logger = report.startTest(TestScriptName);
		return logger;
	}
	
	public static void dropDownSelection(WebElement obj, String objName) {
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("Pass:"  +  objName + " is clicked");
			logger.log(LogStatus.PASS ,objName +" is clicked");
		}
		else {
			System.out.println("Fail:" + objName + " is Not being dispalyed ");
			logger.log(LogStatus.FAIL,objName + " is Not being dispalyed ");
		}
	}
	
	public static void enterText(WebElement obj, String text, String objName) {
		if(obj.isEnabled())	
		{
			obj.sendKeys(text);
			System.out.println("Pass:" + text + "is entered in " + objName + "field..");
			logger.log(LogStatus.PASS,  text + "is entered in " + objName + "field.." );
		}
		else 
		{
			System.out.println("Fail" + text + "is disabled " + objName + "field..");
			logger.log(LogStatus.FAIL, text + "is disabled " + objName + "field..");
		}
	}
	
	public static void validateTextMessage(WebElement obj, String expectedMessage, String objName) {	
		
		if(obj.isEnabled()) {
			String actualMessage;
			actualMessage = obj.getText();
			System.out.println("Pass:"  +  objName + " is enabled");
			logger.log(LogStatus.PASS,  objName + " is enabled");
			if(actualMessage.equals(expectedMessage))	
			{					
				System.out.println("Pass:" + expectedMessage + " is displayed");
				logger.log(LogStatus.PASS,expectedMessage + " is displayed" );
			}
			else {
				System.out.println("Fail:" + objName +" Error message is not displayed" );
				logger.log(LogStatus.FAIL, objName +"Error message is not displayed");
			}
		}
		else {
				System.out.println("Fail: " + objName + "is not enabled" );
				logger.log(LogStatus.FAIL, objName + "is not enabled" );
			}
	}
	public static void validateErrorMessage(WebElement obj, String errorMessage, String objName) {
		if(obj.isDisplayed()) {
			String actualMessage;
			actualMessage = obj.getText();
			System.out.println("Pass:" + objName + errorMessage + " is displayed");
			logger.log(LogStatus.PASS,   errorMessage + " is displayed" );			
		}
		
		else {
			System.out.println("Pass:" + objName + errorMessage + " is not displayed");
			logger.log(LogStatus.PASS, errorMessage + " is not displayed" );			
		}
	}
	
	
	public static void clickButton(WebElement obj, String objName) {
		
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("Pass: " + objName + " field is enabled");
			logger.log(LogStatus.PASS, objName + " field is enabled");
		}
		else {
			System.out.println("Fail: " + objName + " field is not enabled, please check the application");
			logger.log(LogStatus.FAIL, objName + " field is not enabled, please check the application");
		}
	}
	
	public static void enableCheckBox(WebElement obj, String objName) {
		
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("Pass: " + objName + " field is enabled");
			logger.log(LogStatus.PASS,objName + " field is enabled" );
		}
		else {
			System.out.println("Pass: " + objName + " field is not enabled, please check the application");
			logger.log(LogStatus.FAIL, objName + " field is not enabled, please check the application");
		}
		
	}


}
