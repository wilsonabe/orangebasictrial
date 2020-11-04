package com.orphynova.orangebasictrial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestDetailed {
    private WebDriver driver;
    private final String BASE_URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

    @BeforeTest
    public void BeforeTestSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }

    @Test
    public void validLoginTest() {
//        WebElement login = driver.findElement(By.xpath("//*[@id='txtUsername']"));
//        login.sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        String Expected = "Welcome Paul";
        //  String Actual = driver.findElement(By.xpath("//*[@id='welcome']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='welcome']")).getText(), Expected, "Test successful");
    }

    @Test
    public void invalidIDTest() {
        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        String Expected = "Invalid credentials";
        String Actual = driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='spanMessage']")).getText(), Expected, "Test Failed");
    }

    @Test
    public void invalidPwdTest() {
        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("adminxxx");
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        String Expected = "Invalid credentials";
        String Actual = driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='spanMessage']")).getText(), Expected, "Test Failed");
    }
    //************************************************************
    //              EXCEPTION HANDLING
    //************************************************************
    @Test
    public void exceptionHandling() {
        try {
            float d = 3/0; // divide by zero error
            driver.findElement(By.xpath("//*[@id='txtUsernam']"));  // element doest exist

        } catch (NoSuchElementException excepError){
            System.out.println("EXCEPTIONM  occurred  -: "+ excepError.getMessage());
        } catch (ArithmeticException excepError){
            System.out.println("EXCEPTIONM  occurred  -: "+ excepError.getMessage());
        } catch (Exception excepError) {
            System.out.println("EXCEPTIONM  occurred  -: " + excepError.getMessage());
        }finally {
            System.out.println("FINALLY- Block is always  executed");
        }
        System.out.println("Code continues executing !!");
    }

}