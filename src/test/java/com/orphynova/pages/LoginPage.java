package com.orphynova.pages;

import com.orphynova.lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private String txtUserName ="//*[@id='txtUsername']";
    private String txtPassword = "//*[@id='txtPassword']";
    private String btnLogin = "//*[@id='btnLogin']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String Username, String Password){
        setText(By.xpath(txtUserName),Username);
        setText(By.xpath(txtPassword),Password);
        click(By.xpath(btnLogin));

//    driver.findElement(By.xpath(txtUserName)).sendKeys(Username);
//    driver.findElement(By.xpath(txtPassword)).sendKeys(Password);
//    driver.findElement(By.xpath(btnLogin)).click();
}
}
