package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EmulatorChromeTest {
	
	public static void main(String[] args) {
		
		// Set the Desired Capabilities => emulator
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.1");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		
		// Set ChromeDriver location
		// Appium driver siedzi tutaj => C:\Users\toba\AppData\Local\Programs\Appium\resources\app\node_modules\appium-chromedriver\chromedriver\win
		String path = System.getProperty("user.dir");
		caps.setCapability("chromedriverExecutableDir", path + "/src/test/resources/chromedriver_2.34");
		
		// Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		// Open URL in Chrome Browser
		driver.get("http://www.google.com");
	}
}
