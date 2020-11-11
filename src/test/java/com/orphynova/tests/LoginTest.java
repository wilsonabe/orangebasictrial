package com.orphynova.tests;

import com.orphynova.lib.TestBase;
import com.orphynova.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

        @Test
        public void validLoginTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("Admin","admin123").assertWelcomeMessage();

      //  new HeaderPage(driver).assertWelcomeMessage();
        }

        @Test
        public void invalidLoginTest() {
                LoginPage loginpage = new LoginPage(driver);
                loginpage.invalidlogin("admin12","admin","Invalid credentials");

        }

    }
