package com.demoqa.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    //поле E-mail
    private By fieldEmail = By.xpath(".//input[@id='userEmail']");
    //поле Mobile
    private By fieldMobile = By.xpath(".//input[@id='userNumber']");
    //поле Date of Birth
    private By fieldDateOfBirth = By.xpath(".//input[@id='dateOfBirthInput']");


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

    @Step("заполнение поля Email")
    public void fillingFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step ("выбор радиокнопки Gender")
    public void selectGender(int numberGender) {
        driver.findElement(By.xpath(".//input[@id='gender-radio-"+numberGender+"']/parent::div")).click();
    }

    @Step ("заполнение поля Mobile")
    public void fillingFieldMobile(String mobile) {
        driver.findElement(fieldMobile).sendKeys(mobile);
    }

    @Step ("кликнуть на поле Date of Birth") //исправить сам метод на заполнение поля
    public void clickOnFieldDateOfBirth() {
        WebElement element = driver.findElement(fieldDateOfBirth);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }
}
