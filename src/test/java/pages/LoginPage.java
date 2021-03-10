package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public By txtBoxUserName=By.xpath("//input[@id='username-inp']");
	By txtBoxPassword=By.xpath("//input[@id='password-inp']");
	By btnSignIn= By.xpath("//button[@id='signInSubmitButton']");
	public By errorUName=By.xpath("//app-error-message[@data-qa='signin-inp-username-error']/div");
	public By errorPword=By.xpath("//app-error-message[@data-qa='signin-inp-password-error']/div");
	public By lblSignIn=By.xpath("//*[@data-qa='signin-div-error-display']/p");
	public By lblAccount=By.xpath("//section/div/p");
	public By lblTxtSignIn=By.xpath("//*[@data-qa='signin-div-error-display']");
		
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebElement txtBoxUserName() {
		return this.driver.findElement(this.txtBoxUserName);
	}

	public void EnterUserName(String userName) {
		this.txtBoxUserName().sendKeys(userName);
	}
	
	public WebElement txtBoxPassword() {
		return this.driver.findElement(this.txtBoxPassword);
	}

	public void EnterPassword(String password) {
		this.txtBoxPassword().sendKeys(password);
	}
	
	public WebElement btnSignIn() {
		return this.driver.findElement(this.btnSignIn);
	}
	
	public void clickSignIn() {	
		this.btnSignIn().click();
	}
	public WebElement errorUName() {
		return this.driver.findElement(this.errorUName);
	}
	
	public String getUserNameError() {	
		return this.errorUName().getText();
	}
	public WebElement errorPWord() {
		return this.driver.findElement(this.errorPword);
	}
	
	public String getPasswordError() {	
		return this.errorPWord().getText();
	}
	
	public WebElement lblSignIn() {
		return this.driver.findElement(this.lblTxtSignIn);
	}
	
	public String getSignInError() {
		return this.lblSignIn().getText();
		
	}
	
	public WebElement lblAccounts() {
		return this.driver.findElement(this.lblAccount);
	}
	
	
    public boolean IsElementDisplayed(By element)
    {
        if (this.driver.findElements(element).size() > 0)
        {
            if (driver.findElement(element).isDisplayed())
                return true;
            else
                return false;
        }
        else
        {
            return false;
        }
    }
	
}
