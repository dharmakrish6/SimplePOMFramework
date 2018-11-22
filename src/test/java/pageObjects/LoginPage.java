package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage{
	
	@FindBy(id = "com.tv.v18.viola:id/email")
	private WebElement emailTextBox;
	
	@FindBy(id = "com.tv.v18.viola:id/login_btn_lyt")
	private WebElement loginButton;
	
	@FindBy(id = "com.tv.v18.viola:id/password")
	private WebElement passwordTextBox;
	
	@FindBy(id="com.tv.v18.viola:id/skip_txt")
	private WebElement skipButton;
	
	@FindBy(id="com.tv.v18.viola:id/gateway_btn_view")
	private WebElement vootButton;
	
	@SuppressWarnings("unchecked")
	public LoginPage(WebDriver driver) {
		BasePage.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logintoApp(String email,String password) {
		waitTillElementClickable(emailTextBox);
		emailTextBox.sendKeys(email);
		loginButton.click();
		waitTillElementClickable(passwordTextBox);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}
	
	public void clickOnVootButton() {
		waitTillElementClickable(vootButton);
		vootButton.click();
		
	}
	
	public void clickOnSkipandExplore() {
		waitTillElementClickable(emailTextBox);
		scrollToElement(skipButton);
		skipButton.click();
		
	}


}
