package functionalTestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import apiValidations.VootAPIValidate;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShowPage;

public class ValidatePlayerFeature extends BasePage {
	LoginPage lpage;
	HomePage hPage;
	ShowPage sPage;
	VootAPIValidate api;
	@Test
	public void ValidateShowsTabData() throws IOException, InterruptedException {
		launchApp();
		lpage=new LoginPage(driver);
		lpage.clickOnSkipandExplore();
		lpage.clickOnVootButton();
		hPage=new HomePage(driver);
		hPage.hideCastingView();
		hPage.clickOnShowsTab();
		sPage=new ShowPage(driver);
		sPage.playContent();
		sleep(15000);
		sPage.clickOnCordinates(355, 251);
		sleep(2000);
		sPage.clickOnCordinates(355, 251);
		sPage.clickOnCordinates(673, 105);
		sleep(2000);
		sPage.clickOnCordinates(366, 936);
		
	}
}
