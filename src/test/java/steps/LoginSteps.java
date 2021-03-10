package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.ModulrTestConfig;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginSteps extends ModulrTestConfig {
	WebDriver driver= initialiseDriver();
	LoginPage loginPage= new LoginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@Given("^User launched Modulr Customer Portal$")
	public void user_launched_Modulr_Customer_Portal() throws InterruptedException {
		this.driver.get(super.ModulrPortalUrl);	
		wait.until(ExpectedConditions.presenceOfElementLocated(this.loginPage.txtBoxUserName));
		this.driver.manage().window().maximize();
	}

	@When("^User provides \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_and(String userName, String password) {
			this.loginPage.EnterUserName(userName);
			this.loginPage.EnterPassword(password);
			this.loginPage.clickSignIn();
		
	}

	@Then("^The error \"([^\"]*)\" displayed to the user$")
	public void validate_that_the_error_displayed(String errorMsg) throws InterruptedException{
	   if(this.loginPage.txtBoxUserName().getAttribute("value").isEmpty() && this.loginPage.txtBoxPassword().getAttribute("value").isEmpty()) {
		   assertTrue(this.loginPage.getUserNameError().trim().equals(errorMsg));
		   assertTrue(this.loginPage.getPasswordError().trim().equals(errorMsg));
		   System.out.println("Error message for empty User name and password is displayed");
	   }
	   else if(this.loginPage.txtBoxUserName().getAttribute("value").isEmpty()&& !this.loginPage.txtBoxPassword().getAttribute("value").isEmpty()) {
		   assertTrue(this.loginPage.getUserNameError().equals(errorMsg));
		   assertFalse(this.loginPage.IsElementDisplayed(this.loginPage.errorPword));
		   System.out.println("Error message for empty User name is displayed");
	   }
	   else if(!this.loginPage.txtBoxUserName().getAttribute("value").isEmpty()&& this.loginPage.txtBoxPassword().getAttribute("value").isEmpty()) {
		   assertTrue(this.loginPage.getPasswordError().equals(errorMsg));
		   assertFalse(this.loginPage.IsElementDisplayed(this.loginPage.errorUName));
		   System.out.println("Error message for empty password is displayed");
	   }
	   else {
		   assertFalse(this.loginPage.IsElementDisplayed(this.loginPage.errorUName));
		   assertFalse(this.loginPage.IsElementDisplayed(this.loginPage.errorPword));
		   
		   wait.until(ExpectedConditions.presenceOfElementLocated(this.loginPage.lblSignIn));
		   
		   assertTrue(this.loginPage.getSignInError().contains(errorMsg));
			System.out.println("Error message for incorrect credentials is displayed");
	   }
	}
	
	@And("^Adequate warning for multiple attempts is displayed to the user$")
	public void validate_adequate_warning_for_multiple_attempts() throws InterruptedException {
		String warning= "Multiple incorrect sign-ins could result in your access being locked. If this does happen, you'll receive an email explaining how to reset your access.";
		assertTrue(this.loginPage.getSignInError().contains(warning));
		System.out.println("Warning message displayed to the user correctly");
	}
	
	@Then("^User navigates to account overview page$")
	public void user_navigates_to_account_overview_page() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(this.loginPage.lblAccount));
		System.out.println("Account overview page displayed");
	}

    @After
	public void teardown() {
		driver.quit();
	}
}
