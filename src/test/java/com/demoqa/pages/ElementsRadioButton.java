package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsRadioButton extends BasePage{

    @FindBy(xpath = "//span[text()='Radio Button']/..")
    public WebElement radioButton;
    @FindBy(xpath = "//input[@id='yesRadio']")
    public WebElement yesRadio;
    @FindBy(xpath = "//input[@id='impressiveRadio']")
    public WebElement impressiveRadio;
    @FindBy(xpath = "//input[@id='noRadio']")
    public WebElement noRadio;
    @FindBy(xpath = "//input[@id='yesRadio']/..//label")
    public WebElement yesLabel;
    @FindBy(xpath = "//input[@id='impressiveRadio']/..//label")
    public WebElement impressiveLabel;
    @FindBy(xpath = "//input[@id='noRadio']/..//label")
    public WebElement noLabel;
    @FindBy(xpath = "//p[contains(text(), 'You have selected')]")
    public WebElement resultText;
}
