package com.demoqa.step_definitions;

import com.demoqa.pages.HomePage;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class Task01 {

    HomePage homePage = new HomePage();


    @Given("Navigate to Web Site")
    public void navigateToWebSite() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("Click to HomeIcon")
    public void clickToHomeIcon() {
        homePage.homeIcon.click();
    }

    @Then("Open Home Page")
    public void openHomePage() {
        Assert.assertEquals(ConfigurationReader.get("url"), homePage.getCurUrl());
    }

    @Then("Verify The Footer Text")
    public void verify_the_footer_text() {
        Assert.assertEquals("© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.", homePage.footer.getText());
    }

    @When("Click to JOIN NOW")
    public void click_to_join_now() {
        homePage.seleniumJoin.click();
    }
    @Then("Open ToolsQa Web Site on new Window")
    public void open_tools_qa_web_site_on_new_window() {
        Set<String> windows = Driver.get().getWindowHandles();

        boolean thereIsWindow = false;

        for(String tab:windows){
            Driver.get().switchTo().window(tab);
            if (Driver.get().getCurrentUrl().equals("https://www.toolsqa.com/selenium-training/")){
                thereIsWindow = true;
            }
        }
        Assert.assertTrue(thereIsWindow);
    }

    @Then("The Menu Has Six Items")
    public void the_menu_has_six_items() {
      int menuListSize = homePage.menuList.size();
        Assert.assertEquals(menuListSize, 6);
    }
}
