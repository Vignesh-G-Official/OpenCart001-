package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	//Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confMessage;
	
	//ActionMethods
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		//Solution1
		btnContinue.click();
	
		/*
		//Sol2
		btnContinue.submit();
		
		//Sol3
		btnContinue.sendKeys(Keys.RETURN);
		
		//Sol4
		Actions act=new Actions(driver);
		act.moveToElement(btnContinue).click().perform();
		
		//Sol5
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol6
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		*/
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (confMessage.getText());
		}
		catch (Exception e){
			return (e.getMessage());
		}
	}
	
	
}
