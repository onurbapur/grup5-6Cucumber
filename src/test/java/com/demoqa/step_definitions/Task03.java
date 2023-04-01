package com.demoqa.step_definitions;
import com.demoqa.pages.ElementsCheckBox;
import com.demoqa.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class Task03 {
    HomePage homePage = new HomePage();
    ElementsCheckBox elementsCheckBox = new ElementsCheckBox();
    @Given("Go to Check Box in Elements")
    public void go_to_check_box_in_elements() {
        homePage.elements.click();
        elementsCheckBox.checkBox.click();
    }
    @When("Select the Home")
    public void select_the_home() {
        elementsCheckBox.homeCheckBox.click();
    }
    @Then("Verify that result paragraph is display")
    public void verify_that_result_paragraph_is_display() {
        Assert.assertTrue("result must be display", elementsCheckBox.result.isDisplayed());
    }
    @When("Click to Plus Button")
    public void clickToPlusButton() {
        elementsCheckBox.plusButton.click();
    }
    @And("Click Download File Button")
    public void clickDownloadFileButton() {
        elementsCheckBox.downloadFile.click();
    }
    @Then("Verify expected text by click Download")
    public void verifyExpectedTextByClickDownload() {
        String expectedText = "You have selected :\n" + "downloads\n" + "wordFile\n" + "excelFile";
        Assert.assertEquals(elementsCheckBox.result.getText(), expectedText);
    }
}
