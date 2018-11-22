package pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.ReadCellValue;

public class BasePage extends ReadCellValue {

	public static AndroidDriver<MobileElement> driver;
	DesiredCapabilities cap;

	public void launchApp() throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "6.0.1");
		cap.setCapability("appPackage", "com.tv.v18.viola");
		cap.setCapability("appActivity", "com.tv.v18.viola.views.activities.RSHomeActivity");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("gpsEnabled", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void quitApp() {
		driver.quit();

	}
	public void sleep(int sleeptime) throws InterruptedException {
		Thread.sleep(sleeptime);
		
	}
	public void waitTillElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void scrollToBottom() {
		TouchAction ts = new TouchAction(driver);
		ts.press(360, 900).moveTo(360, 300).release().perform();
	}

	public void scrollToElement(WebElement element) {
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth() / 2;
		int top_y = (int) (dim.getHeight() * 0.25);
		int bottom_y = (int) (dim.getHeight() * 0.20);
		System.out.println("coordinates :" + x + "  " + top_y + " " + bottom_y);
		TouchAction ts = new TouchAction(driver);
		do {
			ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
			System.out.println("Scrolling");
			System.out.println(element.isDisplayed());
		} while (!element.isDisplayed());
	}

	public void scrollToText(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.tv.v18.viola:id/contentFrame\")).getChildByText("
				+ "new UiSelector().className(\"android.widget.TextView\"), \"Top Kannada Shows\")"));
	}

}
