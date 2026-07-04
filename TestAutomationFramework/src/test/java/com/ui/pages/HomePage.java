package com.ui.pages;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.constants.Browser.*;

public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_BUTTON = By.xpath("//button[normalize-space()='Sign in']");
    private static final By USER_NAME = By.cssSelector("a[title='View my customer account'] span"); 
   
    public HomePage(Browser browsername) {
        super(browsername);   
        //goToWebSite(PropertiesUtil.readProperty(QA, "URL"));   
        goToWebSite(JSONUtility.readJSON(QA));
        maximizeWindow();     
    }

    public String getUserName() {
        return getDriver().findElement(USER_NAME).getText();
    }
    public LoginPage goToLoginPage() {
        
        clickOn(SIGN_IN_BUTTON);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
    


}
