package Automate;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.android.AndroidDriver;

public class LaunchAppClass{

	private static AndroidDriver driver;

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		   try {
			   
			    // Create path to open apk and launch tp install 
			    File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/Apps/Ebay/");
				File app = new File(appDir, "ebayy.apk");

				//Create Capabilities to launch app using package and launching activity
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
				capabilities.setCapability("deviceName", AppConstants.DEVICE_NAME);
				capabilities.setCapability("platformVersion", AppConstants.DEVICE_PLATFORM_VERSION);
				capabilities.setCapability("platformName",AppConstants.DEVICE_PLATFORM_NAME);
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", AppConstants.APP_PACKAGE);
				capabilities.setCapability("appActivity", AppConstants.APP_LAUNCHING_ACTIVITY);
 
			    //Create AndroidDriver instance and connect to the Appium server
			    //specified in Desired Capabilities
				driver = new AndroidDriver(new URL(AppConstants.APIUM_SERVER_URL), capabilities);
			    
			    Thread.sleep(15000);
			    
			    //Click nutton of SIGN IN to redirect on login page 
			    //driver.findElementById("com.ebay.mobile:id/button_sign_in").click();
			    
			    driver.findElementById("com.ebay.mobile:id/search_box").click();
			    
			    Thread.sleep(500);
			    
			    driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("65-inch TV"+"\n");
			 
		        Thread.sleep(5000);
	
		        //fetch the listinstance and get the number of items in list to select any rondomly 
			    WebElement element = driver.findElementById("com.ebay.mobile:id/recycler");
			    List <WebElement> list = element.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
			    
			    int generated_random_number = getRandom(list.size());
			    //System.out.println("List SIze-->"+list.size()+"=Random Number="+generated_random_number);
			    list.get(generated_random_number).click();
			    
			    Thread.sleep(2000);
			    
			    String product_price = driver.findElementById("com.ebay.mobile:id/textview_item_price").getText();
			    String product_name = driver.findElementById("com.ebay.mobile:id/textview_item_name").getText();
			    System.out.println("Product Name=="+product_name+"=Product Price="+filterAmount(product_price));
			    
			    assertEquals(product_price, "70499");
			    
			   /* Thread.sleep(1000);
			    driver.close();*/
			   
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Generate a number between the specified max value 
	public static int getRandom(int max){
		Random objGenerator = new Random();
		return objGenerator.nextInt(max);
	}
	
	
	public static int filterAmount(String prodPrice){
		prodPrice =prodPrice.replaceAll("[^\\d.]", "").trim();
		return Integer.parseInt(prodPrice);
	}
	
	
	

}
