package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsTextBox extends BasePage{
    @FindBy(xpath = "//span[text()='Text Box']/..")
    public WebElement textBox;

    @FindBy(xpath = "//div[text()='Elements']/../..")
    public WebElement element_loc;

    @FindBy(id="userName")
    public  WebElement fullname;
    @FindBy(id = "userEmail")
    public WebElement userEmail;
    @FindBy(id="currentAddress")
    public WebElement currentAddress;
    @FindBy(id="permanentAddress")
    public WebElement permanentAddress;
    @FindBy(id="submit")
    public WebElement btnSubmit;
    @FindBy(id="output")
    public WebElement outPutBox;

    public void enterCredentials
            (String name, String email, String currAd, String perAd){
        fullname.sendKeys(name);

        userEmail.sendKeys(email);
        currentAddress.sendKeys(currAd);
        permanentAddress.sendKeys(perAd);
        btnSubmit.click();
    }

}
