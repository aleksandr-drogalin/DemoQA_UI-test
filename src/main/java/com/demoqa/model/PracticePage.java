package com.demoqa.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage {

    private WebDriver driver;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка выбора Practice Form
    private By buttonPracticeForm = By.xpath(".//span[text()='Practice Form']");
    //поле First Name
    private By fieldFirstName = By.xpath(".//input[@id='firstName']");
    //поле Last Name
    private By fieldLastName = By.xpath(".//input[@id='lastName']");


    @Step("выбор раздела Practice Form")
    public void clickOnButtonPracticeForm() {
        driver.findElement(buttonPracticeForm).click();
    }

    @Step("заполнение поля First Name")
    public void fillingFieldFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }

    @Step("заполнение поля Last Name")
    public void fillingFieldLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }
}
