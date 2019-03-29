package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileTest {

	public static void main(String[] args) {

		AppiumDriver<MobileElement> driver = null;

		// Set capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Samsung_J7");
		caps.setCapability("udid", "5203c564b4c2a319");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.vending");
		caps.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
		caps.setCapability("noReset", "true");

		// Instantiate Appium driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		// Added 5 seconds wait so that the app loads completely before starting with
		// element identification
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Find Google Play element and click on it. Then set text in input field
		driver.findElementById("com.android.vending:id/search_box_idle_text").click();
		driver.findElementById("com.android.vending:id/search_box_text_input").sendKeys("google");
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
