package com.demoqa.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    //кнопка раздела Forms
    private By buttonForms = By.xpath(".//h5[text()='Forms']");

    //нажать кнопку Forms
    @Step("выбор раздела Forms на главной странице")
    public void clickOnButtonForms() {
        WebElement elementButtonForms = driver.findElement(buttonForms);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementButtonForms);
        elementButtonForms.click();
    }
}
