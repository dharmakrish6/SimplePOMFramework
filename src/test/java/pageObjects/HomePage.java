package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	@FindBy(xpath = "//*[@text=\"Channels\"]")
	private WebElement channelTab;

	@FindBy(xpath = "//*[@text=\"Shows\"]")
	private WebElement showsTab;

	@FindBy(id = "com.tv.v18.viola:id/media_route_button")
	private WebElement castButton;

	@FindBy(id = "com.tv.v18.viola:id/tv_tray_title")
	public WebElement channelTitleText;

	@FindBy(id ="com.tv.v18.viola:id/episode_title")
	private WebElement episodeTitle;
	
	@FindBy(id ="com.tv.v18.viola:id/hamburger_menu")
	private WebElement menuButton;
	
	@FindBy(id ="com.tv.v18.viola:id/logout_menu")
	private WebElement logoutButton;
	
	@FindBy(id ="com.tv.v18.viola:id/positive_btn")
	private WebElement yesButton;
	@SuppressWarnings("unchecked")
	public HomePage(WebDriver driver) {
		BasePage.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(driver, this);
	}

	public void hideCastingView() {
		waitTillElementClickable(castButton);
		castButton.click();
		driver.navigate().back();

	}

	public void clickOnChannelandVerify() {
		waitTillElementClickable(channelTab);
		channelTab.click();
		waitTillElementClickable(channelTitleText);

	}

	public void clickOnShowsTab() {
		waitTillElementClickable(showsTab);
		showsTab.click();
	}
	public void scrollToMostPopular() {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.tv.v18.viola:id/contentFrame\")).getChildByText("
				+ "new UiSelector().className(\"android.widget.TextView\"), \"Most Popular\")"));
	}
	
	public String validateCarouselData() {
		return episodeTitle.getText().toString();
	}
	
	public void logoutApp() {
		menuButton.click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.tv.v18.viola:id/contentFrame\")).getChildByText("
				+ "new UiSelector().className(\"android.widget.TextView\"), \"Logout\")"));
		logoutButton.click();
		yesButton.click();
		
		
	}

}
