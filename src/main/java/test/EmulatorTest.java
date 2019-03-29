package test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EmulatorTest {

	AppiumDriver<MobileElement> driver = null;
	DesiredCapabilities caps;

	@Before
	public void Initialize() {
		// Set the Desired Capabilities => emulator
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.1");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		caps.setCapability("noReset", true);

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void DividingTest() {
		driver.findElementById("com.android.calculator2:id/digit_8").click();
		driver.findElementById("com.android.calculator2:id/op_div").click();
		driver.findElementById("com.android.calculator2:id/digit_2").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		System.out.println("wynik " + result);
		assertEquals("4", result);
	}
}
