package com.ui.pages; 
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME = By.cssSelector("a[title='View my customer account'] span"); 
    private static final By LOGOUT_BUTTON_LOCATOR = By.cssSelector("a[title='Log me out']"); 

    public MyAccountPage(WebDriver driver) {
        super(driver);        
    }

   

    public LoginPage logout(WebDriver driver) {
       
        clickOn(LOGOUT_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }


    
    


}
