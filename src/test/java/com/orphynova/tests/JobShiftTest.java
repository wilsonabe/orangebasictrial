package com.orphynova.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orphynova.datamodels.jobshifts.JSModel;
import com.orphynova.lib.TestBase;
import com.orphynova.pages.JobShiftPage;
import com.orphynova.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class JobShiftTest extends TestBase {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void addJobShift() throws IOException {    // Adding job shift
        URL url = getClass().getClassLoader().getResource("testdata/jobshifts/jobshifts1.json");
        JSModel jsModel = objectMapper.readValue(url,JSModel.class);
        new LoginPage(driver).login(jsModel.getUser().getUsername(),jsModel.getUser().getPassword()).selectMenu("Admin|Job|Work Shifts");
        JobShiftPage JSPage = new JobShiftPage(driver);
        JSPage.commonAdd(jsModel.getShiftname(),
                jsModel.getAction(),
                jsModel.getFromtime(),
                jsModel.getTotime(),
                jsModel.getEmployee());
//        JSPage.commonAdd("ShiftA","add","09:15", "16:00", "Linda Jane Anderson");


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
