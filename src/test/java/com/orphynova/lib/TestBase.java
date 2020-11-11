package com.orphynova.lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class TestBase {
    protected WebDriver driver;
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com";
    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser){
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void clear(){
        driver.quit();
    }
}