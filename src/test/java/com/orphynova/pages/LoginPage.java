package com.orphynova.pages;

import com.orphynova.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends PageBase {
    private String txtUserName ="//*[@id='txtUsername']";
    private String txtPassword = "//*[@id='txtPassword']";
    private String btnLogin = "//*[@id='btnLogin']";
    private String lblCredentials = "//*[@id='spanMessage']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage login(String Username, String Password) {
        setText(By.xpath(txtUserName), Username);
        setText(By.xpath(txtPassword), Password);
        click(By.xpath(btnLogin));
        return new HeaderPage(driver);

//    driver.findElement(By.xpath(txtUserName)).sendKeys(Username);
//    driver.findElement(By.xpath(txtPassword)).sendKeys(Password);
//    driver.findElement(By.xpath(btnLogin)).click();
    }

    public void invalidlogin(String Username, String Password, String expectedError){
            setText(By.xpath(txtUserName),Username);
            setText(By.xpath(txtPassword),Password);
            click(By.xpath(btnLogin));

        Assert.assertTrue(isElementPresent(By.xpath(lblCredentials)),"Error not displayed");
        String actualError = getText(By.xpath(lblCredentials));      // "Invalid credentials"

        Assert.assertEquals(actualError,expectedError,"Incorrect error message");

    }
}
