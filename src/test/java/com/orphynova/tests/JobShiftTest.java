package com.orphynova.tests;

import com.orphynova.lib.TestBase;
import com.orphynova.pages.JobShiftPage;
import com.orphynova.pages.LoginPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class JobShiftTest extends TestBase {

    @Test
    public void addJobShift() {    // Adding job shift
        new LoginPage(driver).Login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.addBtnClick("ShiftAW2");
        JSPage.selectDropdown("09:15", "16:00");
        JSPage.SelectEmployee("Joe Root");
        JSPage.clickAddEmp();
        JSPage.clickSave("Successfully Saved");
    }

    @Test
    public void addJobShiftCancel() {    // Cancelling job shift Add
        new LoginPage(driver).Login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.addBtnClick("ShiftAW3");
        JSPage.selectDropdown("09:15", "16:00");
        JSPage.SelectEmployee("Joe Root");
        JSPage.clickCancel();
    }



    @Test
    public void cancelDeleteShifts() {    // Delete job shift
        new LoginPage(driver).Login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.selCheckBox("3");
        JSPage.clickCancelDeleteBtn("Delete records?");
    }

    @Test
    public void deleteShifts() {    // Delete job shift
        new LoginPage(driver).Login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.selCheckBox("3");
        JSPage.clickDeleteBtn("Delete records?");
    }
}