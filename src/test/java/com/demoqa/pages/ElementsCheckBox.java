package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsCheckBox extends BasePage{
    @FindBy(xpath = "//span[text()='Check Box']/..")
    public WebElement checkBox;

    @FindBy(xpath="//*[@id='tree-node-home']/..")
    public WebElement homeCheckBox;

    @FindBy(id="result")
    public WebElement result;

    @FindBy(xpath = "//button[@title='Expand all']")
    public WebElement plusButton;

    @FindBy(xpath = "//*[@id='tree-node-downloads']/..")
    public WebElement downloadFile;

}
