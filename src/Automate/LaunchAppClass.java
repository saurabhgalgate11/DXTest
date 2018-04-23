package Automate;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
;

public class LaunchAppClass{

	private static AndroidDriver driver;
	//private static AndroidDriver andDriver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		
		   try {
			    // Create path to open apk and launch tp install 
			    File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/Apps/Ebay/");
				File app = new File(appDir, "ebayy.apk");

				//Create Capabilities to launch app using package and launching activity
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
				capabilities.setCapability("deviceName", "Moto G5s Plus");
				capabilities.setCapability("platformVersion", "7.1.1");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", "com.ebay.mobile");
				capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
 
			    //Create RemoteWebDriver instance and connect to the Appium server
			    //specified in Desired Capabilities
				//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			    
			    Thread.sleep(15000);
			    
			    //Click nutton of SIGN IN to redirect on login page 
			    driver.findElementById("com.ebay.mobile:id/button_sign_in").click();
			   // driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
			    
			   // Thread.sleep(2000);
			   // driver.findElementById("com.ebay.mobile:id/edttxt_username").sendKeys("saurabh");
			    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
