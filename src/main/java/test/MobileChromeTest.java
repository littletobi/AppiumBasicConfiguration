package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileChromeTest {
	public static void main(String[] args) {

		//Set the Desired Capabilities => dziala na moim telefonie
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Samsung_J7");
		caps.setCapability("udid", "5203c564b4c2a319"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.1");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\toba\\Downloads\\chromedriver_win32s\\chromedriver.exe");

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
