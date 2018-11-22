package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ShowPage extends BasePage {

	@FindBy(id = "com.tv.v18.viola:id/banner_image_hero_tray")
	private WebElement bannerImageView;

	@FindBy(id = "com.tv.v18.viola:id/iv_play_icon")
	private WebElement startPlayButton;

	@SuppressWarnings("unchecked")
	public ShowPage(WebDriver driver) {
		BasePage.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(driver, this);
	}

	public void playContent() {
		waitTillElementClickable(bannerImageView);
		bannerImageView.click();
		waitTillElementClickable(startPlayButton);
		startPlayButton.click();
	}

	public void clickOnCordinates(int x, int y) {
		TouchAction ts = new TouchAction(driver);
		ts.press(x, y).release().perform();
	}

}
