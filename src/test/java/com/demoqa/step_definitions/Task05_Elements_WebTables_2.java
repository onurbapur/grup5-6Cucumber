package com.demoqa.step_definitions;

import com.demoqa.pages.ElementsWebTables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task05_Elements_WebTables_2 {
    ElementsWebTables elementsWebTables = new ElementsWebTables();
    @When("Add {int} new rows by JavaFaker")
    public void add_new_rows_by_java_faker(int numberNewRecord) {
        elementsWebTables.addNewRowsByJava(numberNewRecord);
    }
    @When("Select {int} rows for a page")
    public void select_rows_for_a_page(int value) {
        elementsWebTables.selectValueOfRows(value);
    }
    @Then("verify that there are {int} rows on the page")
    public void verify_that_there_are_rows_on_the_page(int expectedNumber) {
        List<WebElement> listOfRowsWE = elementsWebTables.listOfRows;
        Assert.assertEquals(expectedNumber, listOfRowsWE.size());

    }
}
