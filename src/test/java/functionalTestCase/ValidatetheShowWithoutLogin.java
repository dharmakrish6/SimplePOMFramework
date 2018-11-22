package functionalTestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiValidations.VootAPIValidate;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ValidatetheShowWithoutLogin extends BasePage {
	LoginPage lpage;
	HomePage hPage;
	VootAPIValidate api;
	@Test
	public void ValidateShowsTabData() throws IOException {
		launchApp();
		lpage=new LoginPage(driver);
		lpage.clickOnSkipandExplore();
		lpage.clickOnVootButton();
		hPage=new HomePage(driver);
		hPage.hideCastingView();
		hPage.clickOnShowsTab();
		hPage.scrollToMostPopular();
		api=new VootAPIValidate();
		String actual=api.checkRecommendationShows();
		String expected=hPage.validateCarouselData();
		System.out.println(expected+" = "+actual);
		Assert.assertEquals(expected,actual ,"FAIL:Data not matched");
		quitApp();
	}
}
