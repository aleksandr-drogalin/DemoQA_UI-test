package com.demoqa.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    //кнопка Forms
    private By buttonForms = By.xpath(".//h5[text()='Forms']");

    //нажать кнопку Forms
    @Step("нажать кнопку Forms")
    public void clickOnButtonForms() {
        WebElement element = driver.findElement(buttonForms);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
        element.click();
    }
}
