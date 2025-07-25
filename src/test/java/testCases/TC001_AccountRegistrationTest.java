package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
			try
			{
			//Creating object to call methods from HomePage page object model
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link....");
			
			hp.clickRegister();
			logger.info("Clicked on Register Link....");
			
			//Creating object to call methods from AccountRegistrationPage page object model
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			logger.info("Providing customer information....");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString().toLowerCase()+"@yopmail.com");
			regpage.setTelephone(randomNumber());
			
			String pwd=randomAlphaNumeric();
			regpage.setPassword(pwd);
			regpage.setConfirmPassword(pwd);
			
			regpage.clickPolicy();
			regpage.clickContinue();
			
			logger.info("Validating expected message.....");
			String confmsg=regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
				logger.info("Test passed....");
			}
			else
			{
				logger.error("Test failed....");
				logger.debug("Debug logs....");
				Assert.assertTrue(false);
			}
			}	
			catch(Exception e)
			{
				Assert.fail();
			}
			
			logger.info("****Finished TC001_AccountRegistrationTest ****");
	}
}
