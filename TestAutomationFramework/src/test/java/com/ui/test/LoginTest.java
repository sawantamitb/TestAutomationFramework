package com.ui.test;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;

public class LoginTest
{
  HomePage homePage;

      @BeforeMethod(description = "Setup Method to Initialize the Browser and HomePage")
      public void setUp()
      {
        homePage = new HomePage(Browser.EDGE);
      }

    @Test (description = "Login Test for Automation Practice Website", groups = {"smoke", "regression"})
    public void loginTest()
    {
      /* homePage.goToWebSite("https://automationpractice.techwithjatin.com/login");
      homePage.maximizeWindow(); */
      
      homePage.goToLoginPage().doLoginWith("labisok230@hidevak.com", "Test@123");
      System.out.println("Login Test Completed Successfully for " + homePage.getUserName());
      assertEquals("Amit Sawant", homePage.getUserName());
      homePage.closeBrowser();
    }
}