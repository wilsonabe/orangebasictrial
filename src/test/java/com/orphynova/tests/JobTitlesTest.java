package com.orphynova.tests;

import com.orphynova.lib.TestBase;
import com.orphynova.pages.LoginPage;
import org.testng.annotations.Test;

public class JobTitlesTest extends TestBase {
    @Test
    public void addJobTitle(){
        new LoginPage(driver)
                .login("admin", "admin123")
                .selectMenu("Admin|Job|Job Titles");
    }
}
