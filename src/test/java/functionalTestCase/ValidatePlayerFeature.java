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
		//We were not able to find the element because of DRM restriction, we used coordinates to interact with Elements
		//Works fine only with Moto G3
		//click on player
		sPage.clickOnCordinates(355, 251);
		sleep(2000);
		//Click on playbutton
		sPage.clickOnCordinates(355, 251);
		//click on setting icon
		sPage.clickOnCordinates(673, 105);
		sleep(2000);
		//click n low quality
		sPage.clickOnCordinates(366, 936);
		
	}
}
