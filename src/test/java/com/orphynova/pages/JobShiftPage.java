package com.orphynova.pages;

import com.orphynova.lib.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobShiftPage extends PageBase {
   private String btnAdd = "//*[@id='btnAdd']";
   private String btnDelete = "//*[@id='btnDelete']";
   private String chkCommon = "//*[@id='ohrmList_chkSelectAll']";
   private String txtShift = "//*[@id='workShift_name']";    // Job_Shift_Name TextBox
   private String selWSFrom = "//*[@id='workShift_workHours_from']"; // WrokShift From
   private String selWSTo = "//*[@id='workShift_workHours_to']"; // WorkShift To
   private String selAvlEmp = "//*[@id='workShift_availableEmp']"; // Available employee
   private String selAssignEmp = "//*[@id='workShift_assignedEmp'] "; // Assigned employee
   private String clkAdd = "//*[@id='btnAssignEmployee']";  // Add employee
   private String clkRemove = "//*[@id='btnRemoveEmployee']"; // Remove employee
   private String btnSave = "//*[@id='btnSave']";       // SAVE button
   private String btnCancel = "//*[@id='btnCancel']";    // Cancel button
   private String workShift = "//*[@id='search-results']//following::*[text()='Work Shifts']";
   private String selRecord = "//*[@name='chkSelectRow[]']//following::*[@value='X']";
   private String actualAlertMsg = "//*[@id='customerList']//following::*[text()='Delete records?']";
   private String btnAlertOK = "//*[@id='customerList']//following::*[@value='Ok']";
   private String btnAlertCancel = "//*[@id='customerList']//following::*[@value='Cancel']";


   public void clickDeleteBtn(String expAlertMsg) {
      click(By.xpath(btnDelete));
      // Confirming delete alert
      Alert alertMsg = driver.switchTo().alert();
     // By.xpath(actualAlertMsg)
     // Boolean confirm = isElementVisible(By.xpath(actualAlertMsg));// System.out.println(confirm);
      Assert.assertEquals(alertMsg.getText(),expAlertMsg,"Alert did not pop up !");
      sleep(100);
      alertMsg.accept();

      //   click(By.xpath(btnAlertOK));
   }
   public void clickCancelDeleteBtn(String expAlertMsg) {
      click(By.xpath(btnDelete));
      // Confirming delete alert
      Assert.assertEquals(By.xpath(actualAlertMsg),expAlertMsg,"Alert did not pop up !");
      click(By.xpath(btnAlertCancel));
   }

   public JobShiftPage(WebDriver driver) {
      super(driver);
   }

   public void addBtnClick(String ShiftName) {
      click(By.xpath(btnAdd));
      setText(By.xpath(txtShift), ShiftName);
      //select(By.xpath(selWSFrom),FromTime);
      // select(By.xpath(selWSTo),ToTime);
   }

   public void selectDropdown(String FromTime, String ToTime) {
      select(By.xpath(selWSFrom), FromTime);
      select(By.xpath(selWSTo), ToTime);
   }

   public void SelectEmployee(String employees) {
      select(By.xpath(selAvlEmp), employees);
   }

   public void clickAddEmp() {   // click Add button
      click(By.xpath(clkAdd));
   }

   public void clickRemove() {    // click Remove button
      click(By.xpath(clkRemove));
   }

   public void clickSave(String msgExp) {    // Click SAVE button
      click(By.xpath(btnSave));
      // Successfully saved message should appear
      String msgActual = getText(By.xpath("//*[@id='successBodyEdit']"));
      Assert.assertEquals(msgActual, msgExp, "Record not Saved");  // check Successfully saved message
   }

   public void clickCancel() {    // CANCEL operation
      click(By.xpath(btnCancel));
      //Check is "work Shifts" is visible
      Assert.assertTrue(isElementVisible(By.xpath(workShift)), "Work Shifts displayed");
   }



   public void selCheckBox(String value) { // selecting check box
      click(By.xpath(selRecord.replace("X", value)));
   }

}
