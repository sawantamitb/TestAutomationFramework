package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest
{
    public static void main(String[] a)
    {
       WebDriver wd =  new ChromeDriver();
       wd.get("https://automationpractice.techwithjatin.com");
       wd.manage().window().maximize();
       By signLinkLocator = By.xpath("//a[normalize-space()='Sign in']");
       WebElement signLinkWebElement = wd.findElement(signLinkLocator);
       signLinkWebElement.click();
       
       By userNameLocator = By.xpath("//input[@id='email']");
       By passwordLocator = By.cssSelector("#passwd");
       By signInButton = By.xpath("//span[normalize-space()='Sign in']");
       
       WebElement userNameWebElement = wd.findElement(userNameLocator);
       userNameWebElement.sendKeys("labisok230@hidevak.com");
       
       WebElement passwordWebElement = wd.findElement(passwordLocator);
       passwordWebElement.sendKeys("Test@123");
       
       WebElement signInButtonWebElement = wd.findElement(signInButton);
       signInButtonWebElement.click();
       
            
    }
}