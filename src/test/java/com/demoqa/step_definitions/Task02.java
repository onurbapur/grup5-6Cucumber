package com.demoqa.step_definitions;

import com.demoqa.pages.ElementsTextBox;
import com.demoqa.pages.HomePage;
import com.demoqa.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;
import java.util.Objects;
public class Task02 {
    HomePage homePage = new HomePage();
    ElementsTextBox elementsTextBox = new ElementsTextBox();
    @Given("Go to Text Box in Elements")
    public void go_to_text_box_in_elements() {
        homePage.elements.click();
        elementsTextBox.textBox.click();
    }
    @When("Enter the credentials")
    public void enter_the_credentials(Map<String, String> dataMap) {
        elementsTextBox.enterCredentials(dataMap.get("name"), dataMap.get("email"),
                dataMap.get("currentAddress"), dataMap.get("permanentAddress"));
        BrowserUtils.waitFor(3);
    }
    @Then("Verify that get error message by empty email")
    public void verify_that_get_error_message() {
        System.out.println("elementsTextBox.userEmail.getAttribute(\"validationMessage\") = " + elementsTextBox.userEmail.getAttribute("validationMessage"));
        Assert.assertNotEquals("", elementsTextBox.userEmail.getAttribute("validationMessage"));
    }
    @Then("Verify that get error message by invalid email")
    public void verifyThatGetErrorMessageByInvalidEmail() {
        Assert.assertEquals("Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"falancaAhmetfalanca.com\" adresinde \"@\" eksik.", elementsTextBox.userEmail.getAttribute("validationMessage"));
    }
    @Then("Verify that get output box")
    public void verifyThatGetOutputBox() {
        Assert.assertTrue("outputbox must be display!", elementsTextBox.outPutBox.isDisplayed());
    }
    @Then("Verify that boxes are empty")
    public void verifyThatBoxesAreEmpty() {
        Assert.assertEquals("",elementsTextBox.fullname.getAttribute("value"));
    }
}
