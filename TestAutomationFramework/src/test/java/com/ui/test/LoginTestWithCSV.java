package com.ui.test;

import static org.junit.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTestWithCSV
{
  HomePage homePage;
      // To test using jsonreader and dataprovider, we can use the following code
      @BeforeMethod(description = "Setup Method to Initialize the Browser and HomePage")
      public void setUp()
      {
        homePage = new HomePage(Browser.CHROME);        
      }
    
 
    @Test (description = "Login Test for Automation Practice Website", 
          groups = {"smoke", "regression"}, 
          dataProvider = "loginCSVDataProvider", 
          dataProviderClass = com.ui.dataproviders.LoginDataProvider.class)
    public void loginTestWithCSV(User user)
    {
      homePage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword());
      System.out.println("Login Test Completed Successfully for " + homePage.getUserName());
      assertEquals("Amit Sawant", homePage.getUserName());
      homePage.closeBrowser();
    } 
  }

   