package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	WebDriver driver;
	
	@Given("Launch chrome browser")
	public void launch_chrome_browser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("Step 1: Launch Chrome");
	    
	}

	@Given("Navigate to URL {string}")
	public void navigate_to_url(String string) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Step 2:Open web page");
	 
	}

	@Given("There user log in through Login Window by using Username as {string} and Password as {string}")
	public void there_user_log_in_through_login_window_by_using_username_as_and_password_as(String Username, String Password) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		System.out.println("Step 3:Enter valid credentials" + "Username:" + Username +"Password:" + Password); 
	}

	@Given("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/button")).click();
		System.out.println("Step 5:Click on login buttton");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
	}
	
	@Then("login must be successful")
	public void login_must_be_successful() {
		System.out.println("Step 6:Login must be successfull");
	   
	}

	@Then("Orange Logo must be visible")
	public void orange_logo_must_be_visible() {
		WebElement logo=  driver.findElement(By.xpath("//div[@class='oxd-brand-banner']/img"));
		String S=logo.getText();
		System.out.println("Logo is: "+ S);
	   
	}

	@When("Click on log out")
	public void click_on_log_out() throws Throwable {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit .SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
		System.out.println("Step 8: Perfrom log out");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
	   
	}

	@Then("Log out must be successful")
	public void log_out_must_be_successful() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
		System.out.println("Step 9:Log out successfull back to login page");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit .SECONDS);
	    Thread.sleep(3000);
	    
	}
	
	@Then("Close the browser")
	public void close_the_browser() throws Throwable {	
		driver.manage().timeouts().implicitlyWait(100, TimeUnit .SECONDS);
		Thread.sleep(3000);
	    driver.close();
	    System.out.println("Step 10:Close current browser");
	    
	}

	
}
