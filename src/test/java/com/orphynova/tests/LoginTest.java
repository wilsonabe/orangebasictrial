package com.orphynova.tests;

import com.orphynova.lib.TestBase;
import com.orphynova.pages.HeaderPage;
import com.orphynova.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

        @Test
        public void validLoginTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.Login("admin","admin123");

        new HeaderPage(driver).assertWelcomeMessage();
        }

    }
