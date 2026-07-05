package com.ui.pages;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ui.pojo.User;

public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_INPUT = By.xpath("//input[@id='email']"); 
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='passwd']");
    private static final By SIGN_IN_LINK = By.xpath("//span[normalize-space()='Sign in']");
    
    public LoginPage(WebDriver driver) {
        super(driver);        
    }

    public MyAccountPage doLoginWith(User user) {
        enterText(EMAIL_INPUT, user.getUsername());
        enterText(PASSWORD_INPUT, user.getPassword());
        clickOn(SIGN_IN_LINK);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }
    


}
