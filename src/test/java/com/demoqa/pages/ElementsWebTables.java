package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ElementsWebTables extends BasePage{

    Faker faker = new Faker();

    @FindBy(xpath = "//span[text()='Web Tables']/..")
    public WebElement webTables;

    @FindBy(id="addNewRecordButton")
    public WebElement addBtn;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="userEmail")
    public WebElement userEmail;

    @FindBy(id="age")
    public WebElement age;

    @FindBy(id="salary")
    public WebElement salary;

    @FindBy(id="department")
    public WebElement department;

    @FindBy(id="submit")
    public WebElement submit;

    @FindBy(xpath = "//*[@aria-label='rows per page']")
    public WebElement selectRows;

    @FindBy(xpath = "//*[@class='rt-tbody']/div")
    public List<WebElement> listOfRows;

    public void enterCredentials(String fName, String lName, String email, String ageData, String salaryData, String departmentData){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userEmail.sendKeys(email);
        age.sendKeys(ageData);
        salary.sendKeys(salaryData);
        department.sendKeys(departmentData);
        submit.click();
    }

    public String getTextOfCell(int row, int column){
        WebElement cell = Driver.get().findElement(By.xpath("//div[@class='rt-table']/div[2]/div[" + row + "]/div/div[" + column + "]"));
        return cell.getText();
    }

    public void deleteBtnClick(int rowNumber){
        WebElement dltBtn = Driver.get().findElement(By.xpath("//div[@class='rt-table']/div[2]/div[" + rowNumber + "]/div/div[7]//span[2]"));
       dltBtn.click();
    }

    public void editBtnClick(int rowNumber){
        WebElement edtBtn = Driver.get().findElement(By.xpath("//div[@class='rt-table']/div[2]/div[" + rowNumber + "]/div/div[7]//span[1]"));
        edtBtn.click();
    }

    public int getColumnNumber(String columnName){

        int columnNumber = 0;
        /*
        switch (columnName.toLowerCase()) {
            case "first name":
            case "firstname":
                columnNumber = 1;
                break;
            case "last name":
            case "lastname":
                columnNumber = 2;
                break;
            case "age":
                columnNumber = 3;
                break;
            case "email":
                columnNumber = 4;
                break;
            case "salary":
                columnNumber = 5;
                break;
            case "department":
                columnNumber = 6;
                break;
            default:
                columnNumber = 0;
        }
         */
/*
       columnNumber = switch (columnName.toLowerCase()) {
            case "first name" -> 1;
            case "last name" -> 2;
            case "age" -> 3;
            case "email" -> 4;
            case "salary" -> 5;
            case "department" -> 6;
            default -> 0;
        };*/

         columnNumber = switch (columnName.toLowerCase()) {
            case "first name", "firstname" -> 1;
            case "last name", "lastname" -> 2;
            case "age" -> 3;
            case "email" -> 4;
            case "salary" -> 5;
            case "department" -> 6;
            default -> 0;
        };

        return columnNumber;
    }

    public List<String> getListOfColumn(String column){
        int columnNumber = getColumnNumber(column);
        List<String> list = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            list.add(getTextOfCell(i, columnNumber));
        }
        return list;
    }
    public String emailByName;
    public void setEmailByName(String name) {
        for (int i = 1; i < 11; i++) {
            if (getTextOfCell(i, getColumnNumber("First Name")).equals(name)){
                emailByName = getTextOfCell(i, getColumnNumber("email"));
            }
        }
    }
    public void addNewRowsByJava(int numberNewRecord) {
        for (int i = 0; i < numberNewRecord; i++) {
        addBtn.click();
        enterCredentials(faker.name().firstName(), faker.name().lastName(),
                    faker.internet().emailAddress(),""+faker.number().numberBetween(21, 65),
                    faker.number().digits(5), faker.company().buzzword());
        }
    }
    public void selectValueOfRows(int value) {
        Select numberOfRows = new Select(selectRows);
        numberOfRows.selectByValue(String.valueOf(value));
    }

}
