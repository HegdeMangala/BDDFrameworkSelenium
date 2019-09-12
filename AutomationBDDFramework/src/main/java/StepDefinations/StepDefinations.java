package StepDefinations;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.Utils;
import junit.framework.Assert;

public class StepDefinations {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	
	
	
	@Given("^user is on sign in page$")
	public void user_is_on_sign_in_page()
	{
		//Set the system property and allocate the driver path
		System.setProperty("webdriver.gecko.driver","C:\\Users\\LOOKMYPC\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		//Assign and open the url
		String baseUrl = "http://automationpractice.com/index.php?controller=authentication";
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		
	}
	
	@When("^user enter username , password and clicks on submit$")
	public void user_enter_username_password_and_clicks_on_submit()
	
	{	//Enter the username	
		WebElement username= driver.findElement(By.id("email"));
		username.sendKeys("SeleniumTesting@gmail.com");

		//Enter the password
		WebElement pwd=driver.findElement(By.id("passwd"));
		pwd.sendKeys("Selenium123");
		
		//Click on submit
		WebElement submit = driver.findElement(By.id("SubmitLogin"));
		submit.click();
				
				
	}
	
	@Then("^user adds Tshirt to the cart$")
	public void user_adds_Tshirt_to_the_cart() throws InterruptedException
	{
		new WebDriverWait(driver, 10);
		
		//Navigate to the T-shirt Url
		driver.navigate().to("http://automationpractice.com/index.php?id_category=5&controller=category");

		js=(JavascriptExecutor) driver;
		
		//Scrol down the window
		js.executeScript("window.scrollBy(0,1000)");
		action=new Actions(driver);
		
		//Define static wait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Mouse over Tshirt to add to the cart
		WebElement add = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
		action.moveToElement(add).build().perform();
		
		//Add selected Tshirt to the cart
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement AddToCart=driver.findElement(By.linkText("Add to cart"));
		AddToCart.click();
		
		//Click on Checkout and scroll down
		driver.findElement(By.linkText("Proceed to checkout")).click();
		js.executeScript("window.scrollBy(0,500)");
		
		//verify the order history by getting attribute value
		WebElement qty=driver.findElement(By.xpath("//input[@class='cart_quantity_input form-control grey']"));
		String cart =qty.getAttribute("value");
		System.out.println("Order history is:"+cart);

		//Returns boolean value True or false
		Assert.assertTrue(!cart.isEmpty());
		
	}

	@Then("^user goes to Update profile and updates his first name$")
	 															  
	public void user_goes_to_Update_profile_and_updates_his_first_name() {
		js=(JavascriptExecutor) driver;
		//Scroll up and click on account 
		js.executeScript("window.scrollBy(500,0)");
		WebElement gotoProfile = driver.findElement(By.xpath("//a[@class='account']"));
		gotoProfile.click();
		
		//wait for 30 seconds .Can also use explicit wait here
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//Scroll down and click on my personal information
		js.executeScript("window.scrollBy(0,500)");
		WebElement updateProfile = driver.findElement(By.linkText("MY PERSONAL INFORMATION"));
		updateProfile.click();
		
		//clear the value of firstname text field and update the firstname
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement updateFirstName = driver.findElement(By.id("firstname"));
		updateFirstName.clear();
		updateFirstName.sendKeys("Mangala");

		//Enter current password,New Password and Confirm password
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement currentPassword = driver.findElement(By.id("old_passwd"));
		currentPassword.sendKeys("Selenium123");
		WebElement newPassword = driver.findElement(By.id("passwd"));
		newPassword.sendKeys("Selenium123");
		WebElement confirmPassword = driver.findElement(By.id("confirmation"));
		confirmPassword.sendKeys("Selenium123");
		
		
		//Click on save
		WebElement save =driver.findElement(By.name("submitIdentity"));
		save.click();
		
	}
	
	@And("^user clicks on Log out$")
	public void user_clicks_on_Log_out ()
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement close = driver.findElement(By.linkText("Sign out"));
		close.click();				
		driver.quit();
}


}



