package com.orphynova.orangebasictrial.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BasicSetup {
    private WebDriver driver;
    private final String BASE_URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    public String UserXpath ="//*[@id='txtUsername']";
    public String PwdXpath = "//*[@id='txtPassword']";
    public String Button = "//*[@id='btnLogin']";

    @BeforeTest
    public void BeforeTestSetup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void BeforeMethod(){
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void CloseBrowser()
    {
        driver.quit();
    }

}
