package com.demoqa.pages;


import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    public WebElement homeIcon;

    @FindBy(xpath = "//footer//span")
    public WebElement footer;


    public String getCurUrl(){
        return Driver.get().getCurrentUrl();
    }
}
