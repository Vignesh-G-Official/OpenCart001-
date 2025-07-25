package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("**** Starting TC002_LoginTest ****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccount macc=new MyAccount(driver);
		boolean displayStatus=macc.isMyAccountPageExists();
		//Assert.assertEquals(displayStatus, true, "Login Failed");
		Assert.assertTrue(displayStatus);
		
	}

}
