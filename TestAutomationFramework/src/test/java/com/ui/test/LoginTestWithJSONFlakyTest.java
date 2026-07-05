package com.ui.test;

import static org.junit.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;



public class LoginTestWithJSONFlakyTest
{
  HomePage homePage;
  org.apache.logging.log4j.Logger logger = LoggerUtility.getLogger(this.getClass());
      // To test using jsonreader and dataprovider, we can use the following code
      @BeforeMethod(description = "Setup Method to Initialize the Browser and HomePage")
      public void setUp()
      {
        homePage = new HomePage(Browser.CHROME);        
      }
     
        @Test (description = "Login Test for Automation Practice Website", 
          groups = {"smoke", "regression"}, 
          dataProvider = "loginJSONDataProvider", 
          dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
          retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class) 
    public void loginTestWithCSVFlakyTestCheck(User user)
    {
      logger.info("Test is started");
      homePage.goToLoginPage().doLoginWith(user);
      System.out.println("Login Test Completed Successfully for " + user.getUsername());
      assertEquals("Amit Sawant", homePage.getUserName());
      homePage.closeBrowser();
      logger.info("Test is completed");
    } 
  }

   

