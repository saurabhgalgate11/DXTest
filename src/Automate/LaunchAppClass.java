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

public class LaunchAppClass {

	private static RemoteWebDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		
		   try {
			   File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/Apps/Ebay/");
				File app = new File(appDir, "ebayy.apk");

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
				capabilities.setCapability("deviceName", "Moto G5s Plus");
				capabilities.setCapability("platformVersion", "7.1.1");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", "com.ebay.mobile");
				capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
 
			    //Create RemoteWebDriver instance and connect to the Appium server
			    //It will launch the Calculator App in Android Device using the configurations
			    //specified in Desired Capabilities
			    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
		
	/*	driver = new AppiumDriver<>(service, desiredCapabilities)
		//changes in code
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.quit();*/
	}
	
/*	WebDriver driver;
	 
    @BeforeClass
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity
        //and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "4.4.2");
        capabilities.setCapability("deviceName","EmulatorS4");
        capabilities.setCapability("platformName","Android");
 
        // This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appPackage", "com.android.calculator2");
 
        // This is Launcher activity of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
 
        //Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations
        //specified in Desired Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
 
    @Test
    public void testCal() throws Exception {
        //locate the Text on the calculator by using By.name()
        WebElement two=driver.findElement(By.name("2"));
        two.click();
        WebElement plus=driver.findElement(By.name("+"));
        plus.click();
        WebElement four=driver.findElement(By.name("4"));
        four.click();
        WebElement equalTo=driver.findElement(By.name("="));
        equalTo.click();
        //locate the edit box of the calculator by using By.tagName()
        WebElement results=driver.findElement(By.className("android.widget.EditText"));
        //Check the calculated value on the edit box
        assert results.getText().toString().equals("6"):"Actual value is : "
                +results.getText()+" did not match with expected value: 6";
    }
 
    @AfterClass
    public void teardown(){
        //close the app
        driver.quit();
    }
	
	*/
	
}
