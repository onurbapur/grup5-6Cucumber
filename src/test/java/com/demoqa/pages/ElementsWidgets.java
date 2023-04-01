package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsWidgets extends BasePage{
    @FindBy(xpath = "//div[text()='Widgets']/../..")
    public WebElement widgets;
}
