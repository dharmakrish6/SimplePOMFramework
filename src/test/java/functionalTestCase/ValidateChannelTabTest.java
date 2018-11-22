package functionalTestCase;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ValidateChannelTabTest extends BasePage {
	LoginPage lPage;
	HomePage hPage;
	@Test(priority=1)
	public void validateChannelPage() throws IOException {
		launchApp();
		lPage=new LoginPage(driver);
		lPage.logintoApp(getTestDataValue("Books","email"), getTestDataValue("Books","password"));
		lPage.clickOnVootButton();
		hPage=new HomePage(driver);
		hPage.hideCastingView();
		hPage.clickOnChannelandVerify();
		Assert.assertEquals(hPage.channelTitleText.getText().toString(), "All Channels",
				"Fail:Screen not focused on channel page");
		hPage.logoutApp();
		quitApp();
		
	}
	
	
}
