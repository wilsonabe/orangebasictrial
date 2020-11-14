package com.orphynova.tests;

import com.orphynova.lib.TestBase;
import com.orphynova.pages.JobShiftPage;
import com.orphynova.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class JobShiftTest extends TestBase {
    @Test
    public void addJobShift() {    // Adding job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add","ShiftAW8", "09:15", "16:00", "Linda Jane Anderson");
    }
//

    @Test
    public void addJobShiftCancel() {    // Cancelling job shift Add
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("addCancel","ShiftAW3", "09:15", "16:00", "Charlie Carter");
    }


    @Test
    public void cancelDeleteShifts() {    // Cancel Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.cancelDeleteShifts("4");
    }

    @Test
    public void deleteShifts() {    // Delete job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add","ShiftAW9", "08:15", "16:00", "Dominic Chase");
        JSPage.deleteShifts("3","successfully Deleted");
    }
    @Test
    public void modifyJobShift() {    // Modifying job shift
        new LoginPage(driver).login("Admin", "admin123").selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd("add","ShiftAWC1", "09:15", "16:00", "Melan Peiris");
        JSPage.modifyJobShift("ShiftAWC1","ShiftAWM2","08:30","16:30","Joe Root");
    }
}
