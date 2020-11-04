package com.orphynova.zorangebasiccodel.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BasicSetup {
    private WebDriver driver;
    private final String BASE_URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    private String txtUserName ="//*[@id='txtUsername']";
    private String txtPassword = "//*[@id='txtPassword']";
    private String txtButton = "//*[@id='btnLogin']";

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
