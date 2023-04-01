package com.demoqa.step_definitions;

import com.demoqa.pages.ElementsRadioButton;
import com.demoqa.pages.HomePage;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Task04_RadioButton {
    HomePage homePage = new HomePage();
    ElementsRadioButton elementsRadioButton = new ElementsRadioButton();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
    @Given("Go to Radio Buttons in Elements")
    public void go_to_radio_buttons_in_elements() {

        homePage.elements.click();

        elementsRadioButton.radioButton.click();
    }
    @Then("Verify that Radio Buttons are clickable")
    public void verify_that_radio_buttons_are_clickable() {
        Assert.assertTrue("Yes radio button must be enable", elementsRadioButton.yesRadio.isEnabled());
        Assert.assertTrue("Impressive radio button must be enable", elementsRadioButton.impressiveRadio.isEnabled());
        Assert.assertTrue("No radio button must be enable", elementsRadioButton.noRadio.isEnabled());
    }

    @When("Click to Yes Button")
    public void clickToYesButton() {
        elementsRadioButton.yesLabel.click();
    }

    @Then("Verify Yes text")
    public void verifyYesText() {
        Assert.assertTrue(elementsRadioButton.yesRadio.isSelected());
        Assert.assertEquals(elementsRadioButton.resultText.getText(), "You have selected Yes");
    }

    @When("Click to Impressive Button")
    public void click_to_impressive_button() {
        elementsRadioButton.impressiveLabel.click();
    }
    @Then("Verify Impressive text")
    public void verify_impressive_text() {
        Assert.assertTrue(elementsRadioButton.impressiveRadio.isSelected());
        Assert.assertEquals("You have selected Impressive",elementsRadioButton.resultText.getText()) ;
    }

    @When("Click to No Button")
    public void click_to_no_button() {
        elementsRadioButton.noLabel.click();
    }
    @Then("Verify No text")
    public void verify_no_text() {
        Assert.assertTrue(elementsRadioButton.noRadio.isSelected());
        Assert.assertEquals("You have selected Impressive",elementsRadioButton.resultText.getText());
    }
}
