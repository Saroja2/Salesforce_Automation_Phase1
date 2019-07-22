package automationScriptsWithReusableMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationScriptsWithReusableMethods.*;

public class AutomationScriptsTest extends ReusableMethods
{
	
	//static WebDriver driver;
	
	static Actions act;
	
	
		
	@BeforeTest
	public static void initialize_driver() 
	{
		System.setProperty("webdriver.chrome.driver","/Users/Saroja/Documents/Seleniumtraining/chromedriver");
		driver = new ChromeDriver();
	}
	
//	public static void launchUrl()
//	{
//		initialize_driver();
//		driver.get("https://www.salesforce.com");
//		driver.manage().window().maximize();
//		System.out.println("Salesforce application opened");
//		
//	}		
			
	@Test(priority=1)	
	public static void navigateToSFDC() throws InterruptedException
	{
		
			launchUrl();
			act = new Actions(driver);
			   
			CreateTestScriptReport("navigateToSFDC");
			
			System.out.println("Navigate to SFDC");		
			//Login Page
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.elementToBeClickable(By.className("global-nav-login-flydown")));
			Thread.sleep(5000);
			WebElement loginDropDown = driver.findElement(By.className("global-nav-login-flydown"));
			act.moveToElement(loginDropDown).build().perform();
			dropDownSelection( loginDropDown,  "login" );
			Thread.sleep(5000);
			
			//EnterUsername
			WebElement userName = driver.findElement(By.id("username"));
			enterText(userName, "saroja.potturi-zkne@force.com", "UserName");
		    
		    //Enter Password
		    WebElement userPassword = driver.findElement(By.id("password"));
		    enterText(userPassword, "", "Password");
		    
		    //Click Login
		    WebElement Login =driver.findElement(By.id("Login"));
			clickButton(Login, "Login button");
			
			//Get Password Error
			WebElement passwordText = driver.findElement(By.id("error"));
			validateErrorMessage(passwordText, "Please enter your password.", "Error Message");
			
		}
		
	@Test(priority=2)
	public static void checkRememberMe() throws InterruptedException{
		
		launchUrl();
		 act = new Actions(driver);
		 CreateTestScriptReport("checkRememberMe");
		 System.out.println("checkRememberMe");
		//Login Page
		 Thread.sleep(5000);
		 WebElement loginDropDown = driver.findElement(By.className("global-nav-login-flydown"));

		act.moveToElement(loginDropDown).build().perform();
		dropDownSelection( loginDropDown,  "login" );

			
		
		//UserName	
		
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "saroja.potturi-zkne@force.com", "UserName");
	    
	    //Password
		
	    WebElement userPassword = driver.findElement(By.id("password"));	    
	    enterText(userPassword, "May!2019", "Password");
	    
	    
	    //RememberMe
	    WebElement rememberMe = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/div[3]/input[1]"));
	    act.moveToElement(rememberMe).build().perform();
	    enableCheckBox(rememberMe, "RememberMe");
	    
	    Thread.sleep(2000);
	    //Click Login
	    WebElement Login =driver.findElement(By.id("Login"));
		clickButton(Login, "Login button");
		Thread.sleep(4000);
		
		//Click UserMenu
		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		clickButton(menuButton, "roja vavi");
		Thread.sleep(2000);
		
		//Logout
		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		clickButton(logout, "Logout");
		Thread.sleep(4000);

		Thread.sleep(2000);		
		//Saved UserName
		WebElement userSaved = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/form[1]/div[1]/a[1]"));
		act.moveToElement(userSaved).build().perform();
		validateTextMessage(userSaved, "1 Saved Username", "UserSaved");
	
		 
	}
	
	@Test(priority=3)
	public static void forgotPassword4A() throws InterruptedException{
		
		launchUrl();
		 act = new Actions(driver);
		 CreateTestScriptReport("forgotPassword4A");
		 System.out.println("forgotPassword4A");
		//Login Page
		Thread.sleep(5000);
		WebElement loginDropDown = driver.findElement(By.className("global-nav-login-flydown"));
		act.moveToElement(loginDropDown).build().perform();
		dropDownSelection( loginDropDown,  "login" );
		Thread.sleep(5000);	
		
	    
	    //ForgotPassword
		WebElement forgotPassword = driver.findElement(By.id("forgot_password_link"));
		act.moveToElement(forgotPassword).build().perform();
		clickButton(forgotPassword, "Forgot Password");
		
		WebElement resetPassword = driver.findElement(By.xpath("//p[@class='username']"));
		validateErrorMessage(resetPassword, "To reset your password, enter your Salesforce username.", "Reset Password");
		
		WebElement continueLogin = driver.findElement(By.xpath("//input[@id='continue']"));
		act.moveToElement(continueLogin).build().perform();
		clickButton(continueLogin, "Continue");	
	
		
}
	@Test(enabled=false)
	public static void forgotPassword4B() throws InterruptedException{
		
		launchUrl();	
		CreateTestScriptReport("forgotPassword4B");
		System.out.println("forgotPassword4B");
		act = new Actions(driver);
		
		//Login Page
		Thread.sleep(5000);
		WebElement loginDropDown = driver.findElement(By.className("global-nav-login-flydown"));
		act.moveToElement(loginDropDown).build().perform();
		dropDownSelection( loginDropDown,  "login" );
		Thread.sleep(7000);	
		
		//EnterUsername
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "123", "UserName");
	    
	    //Enter Password
	    WebElement userPassword = driver.findElement(By.id("password"));
	    enterText(userPassword, "22131", "Password");
	    
	    //Click Login
	    WebElement Login =driver.findElement(By.id("Login"));
		clickButton(Login, "Login button");
		Thread.sleep(2000);
		
		//Get Password Error
		WebElement credentialsError = driver.findElement(By.xpath("//div[@id='error']"));
		validateTextMessage(credentialsError, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.", "Error Message");
		
	}
	@Test(enabled=false)
    public static void selectUserMenu05() throws InterruptedException{
		
		launchUrl();
    	CreateTestScriptReport("selectUserMenu05");
		 act = new Actions(driver);
		System.out.println("selectUserMenu05");
	 
		 //Login Page
		Thread.sleep(7000);
		WebElement loginDropDown = driver.findElement(By.className("global-nav-login-flydown"));
		act.moveToElement(loginDropDown).build().perform();
		dropDownSelection( loginDropDown,  "login" );
		Thread.sleep(5000);	
		
		//UserName
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "saroja.potturi-zkne@force.com", "UserName");
	    
	    //Password
	    WebElement userPassword = driver.findElement(By.id("password"));	    
	    enterText(userPassword, "May!2019", "Password");
	    
	    //Click Login
	    WebElement Login =driver.findElement(By.id("Login"));
		clickButton(Login, "Login button");
		Thread.sleep(5000);
		
		//Click UserMenu
		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		clickButton(menuButton, "roja vavi");
		
		WebElement myProfile =driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		act.moveToElement(myProfile).build().perform();
		dropDownSelection( myProfile,  "MyProfile" );
	
		
    }
    
//    
//		public static void selectUserMenu06() throws InterruptedException{
//				
//	    	CreateTestScriptReport("selectUserMenu05");
//			 act = new Actions(driver);
//			
//			//Login Page
//			WebElement loginDropDown = driver.findElement(By.className("global-nav-login-flydown"));
//			act.moveToElement(loginDropDown).build().perform();
//			dropDownSelection( loginDropDown,  "login" );
//			Thread.sleep(5000);	
//			
//			//UserName
//			WebElement userName = driver.findElement(By.id("username"));
//			enterText(userName, "saroja.potturi-zkne@force.com", "UserName");
//		    
//		    //Password
//		    WebElement userPassword = driver.findElement(By.id("password"));	    
//		    enterText(userPassword, "May!2019", "Password");
//		    
//		    //Click Login
//		    WebElement Login =driver.findElement(By.id("Login"));
//			clickButton(Login, "Login button");
//			Thread.sleep(5000);
//			
//			//Click UserMenu
//			WebElement menuButton = driver.findElement(By.id("userNavLabel"));
//			clickButton(menuButton, "roja vavi");
//			
//			WebElement myProfile =driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
//			act.moveToElement(myProfile).build().perform();
//			dropDownSelection( myProfile,  "MyProfile" );
//			
//			WebElement editButton =driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
//			act.moveToElement(editButton).build().perform();
//			clickButton(editButton, "EditButton");
//	
//			int size=driver.findElements(By.tagName("iframe")).size();
//			System.out.println(size);
//			
//		
//			driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@src='https://login.salesforce.com/login/sessionserver212.html']")));
//			System.out.println("I am in iframe");
//			
//			driver.switchTo().defaultContent();
//			WebElement profileFrame= driver.findElement(By.id("contactInfoContentId"));
//			driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
//			System.out.println("I am inside second frame");
//			
//			WebElement aboutMe = driver.findElement(By.id("aboutTab"));
//			act.moveToElement(aboutMe).build().perform();
//			clickButton(aboutMe, "Tab");
//		
//		
//}
	
		@AfterTest
	public static void logger() {			
			ReusableMethods.report.endTest(logger);
			ReusableMethods.report.flush();
			driver.quit();
		}
		
	
	
//	public static void main(String[] args) throws InterruptedException {
//		
//		
//		initialize_driver();
//		launchUrl();
//		navigateToSFDC();
//		//checkRememberMe();
//		//forgotPassword4A();
//		//forgotPassword4B();
//		//selectUserMenu05();
//		logger();
				
		
//	}


}
