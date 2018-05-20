package step;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class LoginSteps {

	WebDriver driver;
	
	@Given("^I navigated to UPS login page$")
	public void i_navigated_to_UPS_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.ups.com/lasso/login?loc=en_US&returnto=https%3A%2F%2Fwww.ups.com%2Fus%2Fen%2FHome.page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		
	}

	@When("^I input username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_input_username_and_password(String arg1, String arg2) throws Throwable {
	 WebElement userId = driver.findElement(By.xpath("//*[@id='email']"));
	 WebElement password=  driver.findElement(By.xpath("//*[@id='pwd']"));
	 
	 userId.sendKeys(arg1);
	 password.sendKeys(arg2);
	 		
	}

	@And("^I click the submit button$")
	public void i_click_the_submit_button() throws Throwable {
	 WebElement submit = driver.findElement(By.xpath("//*[@id='submitBtn']"));
	 submit.click();	
	}

	
	@Then("^I should be able to login$")
	public void i_should_be_able_to_login() throws Throwable {
	   String actualUrl=driver.getCurrentUrl();
	   String expectedUrl="https://www.ups.com/us/en/Home.page";
	   Assert.assertEquals(actualUrl,expectedUrl);
	   Thread.sleep(2000);
	   driver.close();
		
	}
	
	
}
