package com.ui.pages;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_INPUT = By.xpath("//input[@id='email']"); 
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='passwd']");
    private static final By SIGN_IN_LINK = By.xpath("//span[normalize-space()='Sign in']");
    
    public LoginPage(WebDriver driver) {
        super(driver);        
    }

    public MyAccountPage doLoginWith(String email, String password) {
        enterText(EMAIL_INPUT, "labisok230@hidevak.com");
        enterText(PASSWORD_INPUT, "Test@123");
        clickOn(SIGN_IN_LINK);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }
    


}
