package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CustomKeywords;
import utils.HelperClass;

public class Hook {
	private static int timeout = 3;
	
	@Before
	public static void setup(Scenario scenario) {
		HelperClass.setUpDriver();
		System.out.println("");
		System.out.println("Scenario Name: "+scenario.getName());
		System.out.println("========================================");
		CustomKeywords.initializeObjects();
	}
	
	@AfterStep
    public static void takeScreenshotAfterStep(Scenario scenario) {
		 if (scenario.isFailed()) {
	            // Take screenshot if scenario failed
	            HelperClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Failure Screenshot at Scenario End");
	        }  
    }	
	
	@After
    public static void tearDown(Scenario scenario) {
       
        HelperClass.tearDown();
    }
}