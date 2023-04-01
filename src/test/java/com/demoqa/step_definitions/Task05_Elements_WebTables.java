package com.demoqa.step_definitions;

import com.demoqa.pages.ElementsWebTables;
import com.demoqa.pages.HomePage;
import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task05_Elements_WebTables {
    HomePage homePage = new HomePage();
    ElementsWebTables elementsWebTables = new ElementsWebTables();

    @Given("Go to Web Tables in Elements")
    public void go_to_web_tables_in_elements() {
        homePage.elements.click();
        elementsWebTables.webTables.click();
    }
    @When("Click to Add Button for new record")
    public void click_to_add_button_for_new_record() {
        elementsWebTables.addBtn.click();
    }
    @And("Enter the credentials of person")
    public void enterTheCredentialsOfPerson(Map<String, String> dataMap) {
        BrowserUtils.waitFor(2);
        elementsWebTables.enterCredentials(
                dataMap.get("firstName"), dataMap.get("lastName"), dataMap.get("email"),
                dataMap.get("age"), dataMap.get("salary"), dataMap.get("department"));
        BrowserUtils.waitFor(2);
    }
    @Then("verify add new row by checking email is {string}")
    public void verifyAddNewRowByCheckingEmailIs(String expectedText) {
        String actualText = elementsWebTables.getTextOfCell(4, 4);
        Assert.assertEquals(expectedText, actualText);
    }
    @When("Click Delete Button on a row by email {string}")
    public void deleteARowByEmail(String deleteEmail) {
        List<String> list = elementsWebTables.getListOfColumn("email");
        Assert.assertTrue(list.contains(deleteEmail));

        String email = "";
        for (int i = 1; i < 11; i++) {
            email = elementsWebTables.getTextOfCell(i, 4);
            if (email.equals(deleteEmail)) {
                elementsWebTables.deleteBtnClick(i);
            }
        }
        BrowserUtils.waitFor(2);
    }
    @Then("Verify that the row by email {string} is deleted")
    public void verifyThatTheRowByEmailIsDeleted(String deletedEmail) {
        List<String> list = elementsWebTables.getListOfColumn("email");
        Assert.assertFalse(list.contains(deletedEmail));
        BrowserUtils.waitFor(2);
    }
    @When("Click Edit Button on a row by email {string}")
    public void click_edit_button_on_a_row_by_email(String email) {
        for (int i = 1; i < 11; i++) {
            if (elementsWebTables.getTextOfCell(i, 4).equals(email)){
                elementsWebTables.editBtnClick(i);
            }
        }
    }
    @When("Edit Salary {string}")
    public void edit_salary(String newSalary) {
        elementsWebTables.salary.clear();
        elementsWebTables.salary.sendKeys(newSalary);
    }
    @When("Click Submit Button")
    public void click_submit_button() {
       elementsWebTables.submit.click();
    }
    @Then("Verify that Salary is {string} on a row by email {string}")
    public void verify_that_salary_is_on_a_row_by_email(String expectedSalary, String email) {
        String actualSalary = "";
        for (int i = 1; i < 11; i++) {
            if (elementsWebTables.getTextOfCell(i, 4).equals(email)){
                actualSalary = elementsWebTables.getTextOfCell(i, elementsWebTables.getColumnNumber("salary"));
            }
        }
        Assert.assertEquals(expectedSalary, actualSalary);
    }

}
