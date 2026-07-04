package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.constants.Browser;

public abstract class BrowserUtility 
{
	private WebDriver driver;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver; // initialize instance variable driver
	}

	
	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(Browser browsername) 
	{
		if (browsername == Browser.CHROME) {
			driver = new ChromeDriver();
		} else if (browsername == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		} else if (browsername == Browser.EDGE) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browsername);
		}
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

	public void navigateBack()
	{
		driver.navigate().back();
	}

	public void navigateForward()
	{
		driver.navigate().forward();
	}

	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	public void navigateTo(String url)
	{
		driver.navigate().to(url);
	}

	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}	

	public String getPageSource()
	{
		return driver.getPageSource();
	}

	public void switchToFrame(By locator)
	{
		WebElement frameElement = driver.findElement(locator);
		driver.switchTo().frame(frameElement);
	}

	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}

	public void switchToAlert()
	{
		driver.switchTo().alert();
	}

	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}

	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
	}

	public void sendKeysToAlert(String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}

	public void switchToWindow(String windowHandle)
	{
		driver.switchTo().window(windowHandle);
	}

	public void switchToDefaultWindow()
	{
		driver.switchTo().defaultContent();
	}

	public void switchToNewWindow()
	{
		String currentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void switchToParentWindow()
	{
		String currentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void switchToChildWindow()
	{
		String currentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String title)
	{
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void switchToWindowByUrl(String url)
	{
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			if (driver.getCurrentUrl().equals(url)) {
				break;
			}
		}
	}

	 public String getUserName(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isUserNameDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

	public void switchToWindowByIndex(int index)
	{
		int currentIndex = 0;
		for (String windowHandle : driver.getWindowHandles()) {
			if (currentIndex == index) {
				driver.switchTo().window(windowHandle);
				break;
			}
			currentIndex++;
		}
	}

	public void performAction()
	{
		Actions actions = new Actions(driver);
		actions.perform();
	}

	public void performActionWithElement(By locator)
	{
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void performActionWithOffset(int xOffset, int yOffset)
	{
		Actions actions = new Actions(driver);
		actions.moveByOffset(xOffset, yOffset).perform();
	}

	public void performActionWithElementAndOffset(By locator, int xOffset, int yOffset)
	{
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element, xOffset, yOffset).perform();
	}

	public void buildActionSequence(By locator, CharSequence... keys)
	{
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).sendKeys(keys).perform();
	}

	public void buildActionSequenceWithOffset(int xOffset, int yOffset, CharSequence... keys)
	{
		Actions actions = new Actions(driver);
		actions.moveByOffset(xOffset, yOffset).sendKeys(keys).perform();
	}

	public void buildActionSequenceWithElementAndOffset(By locator, int xOffset, int yOffset, CharSequence... keys)
	{
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element, xOffset, yOffset).sendKeys(keys).perform();
	}

	public void goToWebSite(String url)
	{
		driver.get(url);
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().fullscreen();
	}
	
	public void clickOn(By locator)
	{
		 WebElement element= driver.findElement(locator);
		 element.click();
	}
	
	public void enterText(By locator, String text)
	{
		 WebElement element= driver.findElement(locator);
		 element.sendKeys(text);
	}
	

}

