package utils;

import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HelperClass {
private static HelperClass helperClass;
    
    private static WebDriver driver;
       
	private HelperClass() {	
		
		Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.geolocation", 2);  // 1 for allow, 2 for block
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--headless");
		options.addArguments("--start-maximized");
		options.addArguments("--window-size=1920,1080");
		
		int timeout = 10;
		
		try {
			driver = new RemoteWebDriver(new URL("https://selenium-jkt.antikode.dev/wd/hub"), options);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
     }      
               
	public static void openPage(String url) {
        driver.get(url);
    }
           
    public static WebDriver getDriver() {
        return driver;              
    }
       
    public static void setUpDriver() {
           
        if (helperClass==null) {
               
            helperClass = new HelperClass();
        }
    }
       
    public static void tearDown() {
    	
        if(driver!=null) {
             driver.close();
             driver.quit();
        }
            
       helperClass = null;
   }
}
