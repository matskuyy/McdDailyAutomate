package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomKeywords {
	private static WebDriverWait wait;
    private static JavascriptExecutor js;
    private static Actions actions;

    public static void initializeObjects() {
        WebDriver driver = HelperClass.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
	
	public static WebElement waitForClickableElement(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            // Catching NoSuchElementException and rethrowing it as RuntimeException
            throw new RuntimeException("Element not found: " + e.getMessage(), e);
        } catch (TimeoutException e) {
            // Catching TimeoutException and rethrowing it as RuntimeException
            throw new RuntimeException("Timeout waiting for element to be clickable: " + e.getMessage(), e);
        }
    }
	
	 public static void setUp() {
	        if (wait == null) {
	            wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	        }
	    }
	
	public static WebElement waitForClickableDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            // Catching NoSuchElementException and rethrowing it as RuntimeException
            throw new RuntimeException("Element not found: " + e.getMessage(), e);
        } catch (TimeoutException e) {
            // Catching TimeoutException and rethrowing it as RuntimeException
            throw new RuntimeException("Timeout waiting for element to be displayed: " + e.getMessage(), e);
        }
    }
	
	
	public static WebElement waitForVisibility(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            // Catching NoSuchElementException and rethrowing it as RuntimeException
            throw new RuntimeException("Element not found: " + e.getMessage(), e);
        } catch (TimeoutException e) {
            // Catching TimeoutException and rethrowing it as RuntimeException
            throw new RuntimeException("Timeout waiting for element to be visible: " + e.getMessage(), e);
        }
    }
	
	public static boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }
	
	public static boolean isPresent(WebElement element) {
		try {
	        element.getTagName();
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
    }
	
	public static boolean waitForElementToBeSelected(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (TimeoutException e) {
            return false;
        }
    }
	
	public static boolean waitForElementToBePresent(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }
	
	public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed(); // Check if the element is displayed
        } catch (NoSuchElementException | NullPointerException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
	
	public static void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public void customclick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", element);
		}
	}
	
	public static void hoverOverElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }
	
	public static void doubleClick(WebElement element) {
        actions.doubleClick(element).build().perform();
    }

    public static void rightClick(WebElement element) {
        actions.contextClick(element).build().perform();
    }
    
    public static void selectOptionFromDropdown(WebElement dropdownElement, String optionText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }
    
    public static void enter() {
		actions.keyDown(Keys.ENTER)
        .perform();
	}
}