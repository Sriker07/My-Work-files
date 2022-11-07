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

public class GNTC_steps {
	
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
		driver.get("https://alpha1.giantfoodstores.com/");
		System.out.println("Step 2:Open web page");
	 
	}
	
	
	
	@Given("Navigate to profile link")
	public void navigate_to_profile_link() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
	    driver.findElement(By.xpath("//button[@id='header-account-button']")).click();
	    System.out.println("Step 3: Select profile icon");
	    
	}
	@Given("Click on Sign in")
	public void click_on_sign_in() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
		 driver.findElement(By.xpath("//button[@id='nav-account-menu-sign-in']")).click();
		    System.out.println("Step 4: Click on sign in");
	    
	}

	@Given("There user log in through Login Window by using Username as {string} and Password as {string}")
	public void there_user_log_in_through_login_window_by_using_username_as_and_password_as(String Username, String Password) {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='LoginForm-password-password']")).sendKeys(Password);
		System.out.println("Step 5:Enter valid credentials" + "Username:" + Username +"Password:" + Password); 
	}
	
	@Given("Click on login button")
	public void click_on_login_button() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
		driver.findElement(By.xpath("//button[@id='sign-in-button']")).click();
		System.out.println("Step 6:Click on login buttton");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
	}
	
	@Then("login must be successful")
	public void login_must_be_successful() {
		System.out.println("Step 7:Login must be successfull");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
	   this.navigate_to_profile_link();
	}
	
	
	@When("Click on log out")
	public void click_on_log_out() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit .SECONDS);
		driver.findElement(By.xpath("//button[@id='nav-account-menu-log-out']")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit .SECONDS);
		System.out.println("Step 8:Click on log out");
	   
	}

	@Then("Log out must be successful")
	public void log_out_must_be_successful() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
		System.out.println("Step 9:Log out successfull back to login page");
	    
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit .SECONDS);
	    driver.close();
	    System.out.println("Step 10:Close current browser");
	    
	}

	
}
	
	
	
